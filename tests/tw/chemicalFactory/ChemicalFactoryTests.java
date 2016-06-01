package tw.chemicalFactory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.*;
import static tw.chemicalFactory.ProcessStage.*;
import static tw.chemicalFactory.ProcessStage.Packager;

/**
 * Created by deepak on 1/6/16.
 */
public class ChemicalFactoryTests {
    @Test
    public void testChemicalFactoryCreated() throws Exception {

        ChemicalFactory factory = new ChemicalFactory(null);

        Assert.assertTrue(factory != null);
    }

    @Test
    public void testReturnsZeroForAll() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemZero", 0, 0, 0, 0, 0));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemZero");

        Assert.assertTrue(factory.getProcessTime(inputChemicals) == 0);

    }

    @Test
    public void testReturnsTenForChemX() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemX");

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 10);

    }


    @Test
    public void testReturnsTenForChemXChemX() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemX");
        inputChemicals.add("chemX");

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 13);

    }

    @Test
    public void testReturnsTenForChemXXZ() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        chemicals.add(new ChemicalInfo("chemZ", 3, 3 , 3, 1, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemX");
        inputChemicals.add("chemX");
        inputChemicals.add("chemZ");

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 17);

    }

    @Test
    public void testReturnsTenForChemYYYXZ() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        chemicals.add(new ChemicalInfo("chemZ", 3, 3 , 3, 1, 1));
        chemicals.add(new ChemicalInfo("chemY", 1, 1 , 2, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>(asList("chemY", "chemY","chemY","chemX", "chemZ"));

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 17);

    }

    @Test
    public void testReturnsTenForChemXChemXWithCustomPipleline() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);
        factory.setPipeline(new ProcessStage[]{Grinder, Grinder, Mixer, Mixer, Reactor, Cooler, Packager});

        ArrayList<String> inputChemicals = new ArrayList<>(asList("chemX", "chemX"));

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 11);
    }


    @Test
    public void testReturnsTenForChemXXZWithCustomPipeline() throws Exception {


        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        chemicals.add(new ChemicalInfo("chemZ", 3, 3 , 3, 1, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);
        factory.setPipeline(new ProcessStage[]{Grinder, Grinder, Mixer, Mixer, Reactor, Cooler, Packager});
        ArrayList<String> inputChemicals = new ArrayList<>(asList("chemX", "chemX", "chemZ"));

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 14);

    }

    @Test
    public void testReturnsTenForChemYYYXZWithCustomPipeline() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        chemicals.add(new ChemicalInfo("chemZ", 3, 3 , 3, 1, 1));
        chemicals.add(new ChemicalInfo("chemY", 1, 1 , 2, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);
        factory.setPipeline(new ProcessStage[]{Grinder, Grinder, Mixer, Mixer, Reactor, Cooler, Packager});

        ArrayList<String> inputChemicals = new ArrayList<>(asList("chemY", "chemY","chemY","chemX", "chemZ"));

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 14);

    }


    @Test
    public void testReturnsTenForChemXYWithCustomPipeline() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        chemicals.add(new ChemicalInfo("chemY", 1, 1 , 2, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);
        factory.setPipeline(new ProcessStage[]{Grinder, Grinder, Mixer, Mixer, Reactor, Cooler, Packager});
        ArrayList<String> inputChemicals = new ArrayList<>(asList("chemX", "chemY"));

        Assert.assertEquals(factory.getProcessTime(inputChemicals), 10);

    }


}
