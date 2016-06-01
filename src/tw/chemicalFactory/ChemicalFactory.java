package tw.chemicalFactory;

import java.util.ArrayList;

import static tw.chemicalFactory.ProcessStage.*;

/**
 * Created by deepak on 1/6/16.
 */
public class ChemicalFactory {

    private final ArrayList<ChemicalInfo> chemicalInfos;
    private ProcessStage[] pipeline = {Grinder, Mixer, Reactor, Cooler, Packager};

    public ChemicalFactory(ArrayList<ChemicalInfo> chemicalInfos) {
        this.chemicalInfos = chemicalInfos;
    }

    public int getProcessTime(ArrayList<String> inputChemicalNames) {
        ArrayList<ChemicalProcessStack> processStacks = getProcessStacks(inputChemicalNames);

        int hours = 0;

        while (true) {
            ArrayList<ChemicalProcessStack> processedStacks = new ArrayList<>();

            for (ProcessStage stage : pipeline) {
                ChemicalProcessStack processedStack = ProcessAllChemicalsAt(processStacks, stage, processedStacks);

                if (processedStack != null) processedStacks.add(processedStack);
            }
            if (processedStacks.size() == 0) break;
            hours++;
        }
        return hours;
    }

    private ChemicalProcessStack ProcessAllChemicalsAt(ArrayList<ChemicalProcessStack> inputChemicalInfo,
                                                       ProcessStage currentMachine,
                                                       ArrayList<ChemicalProcessStack> processedChemicals) {
        ChemicalProcessStack chemicalProcessed = null;

        for (ChemicalProcessStack chemicalStack : inputChemicalInfo)
            if (!processedChemicals.contains(chemicalStack) && chemicalStack.process(currentMachine)) {

                chemicalProcessed = chemicalStack;
                if (currentMachine != Cooler) break;
            }

        return chemicalProcessed;
    }

    private ArrayList<ChemicalProcessStack> getProcessStacks(ArrayList<String> inputChemicalNames) {
        ArrayList<ChemicalProcessStack> inputChemicalInfos = new ArrayList<>();

        for (String chemical : inputChemicalNames)
            for (ChemicalInfo chemicalInfo : chemicalInfos)
                if (chemical.equals(chemicalInfo.getChemicalName()))
                    inputChemicalInfos.add(new ChemicalProcessStack(chemicalInfo));

        return inputChemicalInfos;
    }

    public void setPipeline(ProcessStage[] pipeline) {
        this.pipeline = pipeline;
    }
}

