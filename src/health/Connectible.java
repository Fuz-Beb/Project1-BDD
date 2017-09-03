package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Connectible
{
    // Attributes
    private HashMap<Integer, Artery> tabArtery;
    private HashMap<Integer, Vein> tabVein;
    private HashMap<Integer, Capillaries> tabCapillaries;
    private HashMap<Integer, Ventricle> tabVentricle;
    private HashMap<Integer, SalivaryDuct> tabSalivaryDuct;
    private HashMap<Integer, AirConnectible> tabAirConnectible;
    private HashMap<Integer, Nose> tabNose;
    private HashMap<Integer, Alveoli> tabAlveoli;

    // Comfort Constructor
    public Connectible(Attributes attrs)
    {

    }

    // Getters / Setters

    /**
     * @return the tabArtery
     */
    public HashMap<Integer, Artery> getTabArtery()
    {
        return tabArtery;
    }

    /**
     * @param tabArtery
     *            the tabArtery to set
     */
    public void setTabArtery(HashMap<Integer, Artery> tabArtery)
    {
        this.tabArtery = tabArtery;
    }

    /**
     * @return the tabVein
     */
    public HashMap<Integer, Vein> getTabVein()
    {
        return tabVein;
    }

    /**
     * @param tabVein
     *            the tabVein to set
     */
    public void setTabVein(HashMap<Integer, Vein> tabVein)
    {
        this.tabVein = tabVein;
    }

    /**
     * @return the tabCapillaries
     */
    public HashMap<Integer, Capillaries> getTabCapillaries()
    {
        return tabCapillaries;
    }

    /**
     * @param tabCapillaries
     *            the tabCapillaries to set
     */
    public void setTabCapillaries(HashMap<Integer, Capillaries> tabCapillaries)
    {
        this.tabCapillaries = tabCapillaries;
    }

    /**
     * @return the tabVentricle
     */
    public HashMap<Integer, Ventricle> getTabVentricle()
    {
        return tabVentricle;
    }

    /**
     * @param tabVentricle
     *            the tabVentricle to set
     */
    public void setTabVentricle(HashMap<Integer, Ventricle> tabVentricle)
    {
        this.tabVentricle = tabVentricle;
    }

    /**
     * @return the tabSalivaryDuct
     */
    public HashMap<Integer, SalivaryDuct> getTabSalivaryDuct()
    {
        return tabSalivaryDuct;
    }

    /**
     * @param tabSalivaryDuct
     *            the tabSalivaryDuct to set
     */
    public void setTabSalivaryDuct(HashMap<Integer, SalivaryDuct> tabSalivaryDuct)
    {
        this.tabSalivaryDuct = tabSalivaryDuct;
    }

    /**
     * @return the tabAirConnectible
     */
    public HashMap<Integer, AirConnectible> getTabAirConnectible()
    {
        return tabAirConnectible;
    }

    /**
     * @param tabAirConnectible
     *            the tabAirConnectible to set
     */
    public void setTabAirConnectible(HashMap<Integer, AirConnectible> tabAirConnectible)
    {
        this.tabAirConnectible = tabAirConnectible;
    }

    /**
     * @return the tabNose
     */
    public HashMap<Integer, Nose> getTabNose()
    {
        return tabNose;
    }

    /**
     * @param tabNose
     *            the tabNose to set
     */
    public void setTabNose(HashMap<Integer, Nose> tabNose)
    {
        this.tabNose = tabNose;
    }

    /**
     * @return the tabAlveoli
     */
    public HashMap<Integer, Alveoli> getTabAlveoli()
    {
        return tabAlveoli;
    }

    /**
     * @param tabAlveoli
     *            the tabAlveoli to set
     */
    public void setTabAlveoli(HashMap<Integer, Alveoli> tabAlveoli)
    {
        this.tabAlveoli = tabAlveoli;
    }
}
