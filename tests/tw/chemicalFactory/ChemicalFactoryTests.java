package tw.chemicalFactory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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

/*       chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        chemicals.add(new ChemicalInfo("chemY", 1, 1 , 2, 2, 1));
        chemicals.add(new ChemicalInfo("chemZ", 3, 3 , 3, 1, 1));*/

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemZero", 0, 0, 0, 0, 0));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemZero");

        Assert.assertTrue(factory.processAllChemicals(inputChemicals) == 0);

    }

    @Test
    public void testReturnsTenForChemX() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemX");

        Assert.assertEquals(factory.processAllChemicals(inputChemicals), 10);

    }
    @Test
    public void testReturnsTenForChemXChemX() throws Exception {

        ArrayList<ChemicalInfo> chemicals = new ArrayList<>();
        chemicals.add(new ChemicalInfo("chemX", 3, 3 , 1, 2, 1));
        ChemicalFactory factory = new ChemicalFactory(chemicals);

        ArrayList<String> inputChemicals = new ArrayList<>();
        inputChemicals.add("chemX");
        inputChemicals.add("chemX");

        Assert.assertEquals(factory.processAllChemicals(inputChemicals), 13);

    }
}
