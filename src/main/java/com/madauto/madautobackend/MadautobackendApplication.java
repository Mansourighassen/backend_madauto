package com.madauto.madautobackend;

import com.madauto.madautobackend.config.WebConfig;
import com.madauto.madautobackend.dao.CategoryRepository;
import com.madauto.madautobackend.dao.ProductRepository;
import com.madauto.madautobackend.entities.Category;
import com.madauto.madautobackend.entities.Product;
import com.madauto.madautobackend.entities.Productype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class MadautobackendApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MadautobackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class, Productype.class);
//		ArrayList<String> marques = new ArrayList<String>();
//		marques.add("Volvo");
//		marques.add("BMW");
//		marques.add("Ford");
//		marques.add("Mazda");
//
//
//		 typeproduit[]types=  typeproduit.values();
//
//
//		categoryRepository.save(new Category(null,"Volvo",null,null,null));
//		categoryRepository.save(new Category(null,"BMW",null,null,null));
//		categoryRepository.save(new Category(null,"Ford",null,null,null));
//		categoryRepository.save(new Category(null,"Mazda",null,null,null));
//
//		Random rnd= new Random();
//
//		categoryRepository.findAll().forEach(c->{
//			for (int i = 0; i <10 ; i++) {
//				Product p = new Product();
//				p.setName(RandomString.make(18));
//				p.setCurrentprice(100+rnd.nextInt(10000));
//				p.setAvaiable(rnd.nextBoolean());
//				p.setPromotion(rnd.nextBoolean());
//				p.setPhotoName("unknown.png");
//				p.setSelected(rnd.nextBoolean());
//				p.setAvaiable(rnd.nextBoolean());
//				p.setType( types[ rnd.nextInt(types.length)]);
//				//p.setMarque(marques.get(rnd.ints(0,4).findFirst().getAsInt()));
//
//
//				p.setCategory(c);
//				productRepository.save(p);
//
//
//			}
//
//
//		});



	}
}
