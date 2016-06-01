package tw.chemicalFactory;

import java.util.Stack;

/**
 * Created by deepak on 1/6/16.
 */
public class ChemicalProcessStack {

    String chemicalName;
    Stack<ProcessStage> processStack = new Stack<>();

    public ChemicalProcessStack(ChemicalInfo chemicalInfo) {
        chemicalName = chemicalInfo.getChemicalName();
        pushStage(chemicalInfo.getPackagerTime(), ProcessStage.Packager);
        pushStage(chemicalInfo.getCoolerTime(), ProcessStage.Cooler);
        pushStage(chemicalInfo.getReactorTime(), ProcessStage.Reactor);
        pushStage(chemicalInfo.getMixerTime(), ProcessStage.Mixer);
        pushStage(chemicalInfo.getGrinderTime(), ProcessStage.Grinder);

    }

    private void pushStage(int reps, ProcessStage stage) {
        while (reps > 0) {
            processStack.push(stage);
            reps--;
        }
    }


    public boolean process(ProcessStage currentMachine) {
        if (!processStack.isEmpty() && processStack.peek() == currentMachine) {
            processStack.pop();
            return true;
        }
        return false;
    }

    public String getChemicalName() {
        return chemicalName;
    }
}
