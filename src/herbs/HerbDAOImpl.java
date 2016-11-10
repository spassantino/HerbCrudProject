package herbs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class HerbDAOImpl implements HerbDAO {
	private static final String FILE_NAME = "/WEB-INF/herbs.csv";
	private List<Herb> herbs = new ArrayList<>();
	
	@Autowired
	private WebApplicationContext wac;
	
	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String scientificName = tokens[0];
				String commonName = tokens[1];
				String family = tokens[2];
				String uses = tokens[3];
				String precautions = tokens[4];
				String photo = tokens[5];
				herbs.add(new Herb(scientificName, commonName, family, uses, precautions, photo));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	@Override
	public Herb getHerbByScientificName(String scientificName) {
		Herb s = null;
		for (Herb herb : herbs) {
			if (herb.getScientificName().toLowerCase().startsWith(scientificName.toLowerCase())) {
				s = herb;
			}
		}
		return s;		
	}

	@Override
	public Herb getHerbByCommonName(String commonName) {
		Herb s = null;
		System.out.println(commonName);
		for (Herb herb : herbs) {
			System.out.println(herb);
			if (herb.getCommonName().toLowerCase().startsWith(commonName.toLowerCase())) {
				s = herb;
			}
		}
		return s;
	}

	@Override
	public void addHerb(Herb h) {
		herbs.add(h);
		for (Herb s : herbs) {
			System.out.println(s);
		}
	}

	@Override
	public List<Herb> getHerbs() {
		return herbs;
	}
	@Override
	public void updateHerb(Herb h) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteHerb(Herb h) {
		herbs.remove(h);
		for (Herb s : herbs) {
			System.out.println(s);
	}

	}
}
