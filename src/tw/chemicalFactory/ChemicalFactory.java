package tw.chemicalFactory;

import com.sun.istack.internal.FinalArrayList;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static tw.chemicalFactory.ProcessStage.*;

/**
 * Created by deepak on 1/6/16.
 */
public class ChemicalFactory {

    private final ArrayList<ChemicalInfo> chemicalInfos;
    private final ProcessStage[] pipeline = {Grinder, Mixer, Reactor, Cooler, Packager};

    public ChemicalFactory(ArrayList<ChemicalInfo> chemicalInfos) {

        this.chemicalInfos = chemicalInfos;
    }

    public int processAllChemicals(ArrayList<String> inputChemicalNames) {

        ArrayList<ChemicalProcessStack> inputChemicalInfo = getInfoForInputElements(inputChemicalNames);

        int hours = 0;

        while (true) {
            ArrayList<String> processedChemicals  = new ArrayList<>();;

            for(ProcessStage stage : pipeline){
                String chemicalProcessed = ProcessAllChemicalsAt(inputChemicalInfo, stage, processedChemicals);
                if(chemicalProcessed !=  null) processedChemicals.add(chemicalProcessed);
            }

            if(processedChemicals.size() == 0)break;

            hours++;
        }
        return hours;
    }

    private String ProcessAllChemicalsAt(ArrayList<ChemicalProcessStack> inputChemicalInfo, ProcessStage currentMachine, ArrayList<String> processedChemicals) {
        String chemicalName = null;

        for (ChemicalProcessStack chemicalStack : inputChemicalInfo) {
            if(!processedChemicals.contains(chemicalStack.getChemicalName())
                    && chemicalStack.process(currentMachine)){

                chemicalName = chemicalStack.getChemicalName();
                if(currentMachine != Cooler) break;}
        }
        return chemicalName;
    }

    private  ArrayList<ChemicalProcessStack> getInfoForInputElements(ArrayList<String> inputChemicalNames) {
        ArrayList<ChemicalProcessStack> inputChemicalInfos = new ArrayList<>();

        for (String chemical : inputChemicalNames)
            for (ChemicalInfo chemicalInfo : chemicalInfos){
              if(chemical.equals(chemicalInfo.getChemicalName())){
                  inputChemicalInfos.add(new ChemicalProcessStack(chemicalInfo));
              }
        }

        return inputChemicalInfos;
    }
}

