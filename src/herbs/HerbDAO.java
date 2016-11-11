package herbs;

import java.util.List;

public interface HerbDAO {
	  public Herb getHerbByScientificName(String scientificName);
	  public Herb getHerbByCommonName(String commonName);
	  public void addHerb(Herb h);
	  public void updateHerb(String h);
	  public void deleteHerb(String h);
	  public List<Herb> getHerbs();
}
