package tw.chemicalFactory;

/**
 * Created by deepak on 1/6/16.
 */
public class ChemicalInfo {

    public String getChemicalName() {
        return chemicalName;
    }

    public int getGrinderTime() {
        return grinderTime;
    }

    public int getMixerTime() {
        return mixerTime;
    }

    public int getReactorTime() {
        return reactorTime;
    }

    public int getCoolerTime() {
        return coolerTime;
    }

    public int getPackagerTime() {
        return packagerTime;
    }

    private  String chemicalName;
    private int grinderTime;
    private int mixerTime;
    private int reactorTime;
    private int coolerTime;
    private int packagerTime;

    public ChemicalInfo(String chemicalName, int grinderTime, int mixerTime, int reactorTime, int coolerTime, int packagerTime) {

        this.chemicalName = chemicalName;
        this.grinderTime = grinderTime;
        this.mixerTime = mixerTime;
        this.reactorTime = reactorTime;
        this.coolerTime = coolerTime;
        this.packagerTime = packagerTime;
    }
}
