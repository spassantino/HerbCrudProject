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
	private static final String FILE_NAME = "/WEB-INF/xxx.csv";
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
				String scientificName = tokens[1];
				String commonName = tokens[2];
				String family = tokens[3];
				String uses = tokens[4];
				String precautions = tokens[5];
				String photo = tokens[6];
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
			if (herb.getScientificName().equals(scientificName)) {
				s = herb;
			}
		}
		return s;		
	}

	@Override
	public Herb getHerbByCommonName(String commonName) {
		Herb s = null;
		for (Herb herb : herbs) {
			if (herb.getCommonName().equals(commonName)) {
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

}
