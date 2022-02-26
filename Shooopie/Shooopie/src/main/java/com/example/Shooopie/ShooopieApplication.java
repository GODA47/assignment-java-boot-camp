package com.example.Shooopie;

import com.example.Shooopie.Products.Product;
import com.example.Shooopie.Products.ProductRepo;
import com.example.Shooopie.Products.ProductService;
import com.example.Shooopie.Users.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class ShooopieApplication {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepo productRepo;

	@PostConstruct
	public void initUser(){
		userService.registerUser("GODA", "1234");
	}
	@PostConstruct
	public void initProduct() throws JsonProcessingException {
		//products properties
		String[] productnames;
		String[] descriptions;
		String[] brands;
		String[] colors;
		double[] prices;
		String description;

		{
			//product names
			{
				productnames = new String[]{"Adidas Yeezy Boost 350 V2 Beluga 2.0",
						"Adidas NMD R1 Primeknit Core Black",
						"Adidas NMD R1 PK Japan Triple Black",
						"POCA SHOE NMD Sneakers Fashion",
						"Adidas NMD R1 Color Core Black/Icy Blue"};
			}
			//descriptions
			{
				descriptions = new String[]{"The Yeezy Beluga 2.0 takes Kanye West's famous adidas sneakers full circle by returning to the colors of the first adidas Yeezy Boost 350 V2. While the original colorway featured a bright orange (officially Solar Red) stripe across the side, the 2017 release of the Yeezy Beluga colorway is much more subtle. This colorway utilizes the same Zebra-like stripes as the original but the SPLY-350 branding is the only part of the upper with a contrasted color-this time called Bold Orange. The Yeezy Beluga 2.0 nickname comes from the similarities to the earlier colorway but the official colorway of this adidas Yeezy release is Grey, Bold Orange, and Dark Grey. The toned down color combo made it an appealing shoe for the masses compared to some previous Yeezy colorways. Despite rumors suggesting an October drop, the official release date for the Beluga 2.0 was November 25th, 2017. Since then it has been one of the most active sneakers on StockX, continually selling well above its retail price. You can get the Yeezy Beluga 2.0 on StockX now by placing a Bid or choosing to Buy Now.",
						"Ultra-minimalist. These NMD shoes combine '80s racing heritage with modern materials. They feature a sleek adidas Primeknit upper that offers breathable comfort on hot city streets. Boost cushioning delivers energy return with every stride for all-day comfort. The shoes come with two pairs of laces, one of which has reflective elements",
						"The adidas NMD R1 is back in all-black. Nicknamed the \"Triple Black\" edition, this pair is a part of the \"Japan Boost\" Pack. Sporting a Primeknit upper, BOOST cushioning and a black sole with \"The Brand With The Three Stripes\" written in Japanese on the EVA insert overlay on the midsole as well as on the back heel pull tab. Their release date was August 11th, 2017 where they retailed for $170 in men's sizing. Another perfect adidas NMD R1 for everyday wear. You can never go wrong with a fresh all-black NMD in your rotation. Those looking for a new pair can hit up the marketplace now and buy them. If you have a pair to sell, online is the place to go. There are plenty of buyers ready and willing to cop these clean kicks.",
						"POCA SHOE NMD Sneakers Fashion is a low cost fashion sneakers for both men and women.",
						"The adidas NMD is back with a brand new women’s exclusive colorway that you can get your hands on today for $130 USD. The adidas NMD R1 “Icey Blue” skips out on Primeknit for a simple breathable mesh construction while matching three stripe branding allows for 2 different shades of blue to catch your eye on the midsole bumpers. A full-length Boost midsole cushioning system adds extreme comfort in the usual white shade to contrast with a black outsole."};
			}
			//brands
			{
				brands = new String[]{"Adidas",
						"Adidas",
						"Adidas",
						"POCA",
						"Adidas"};
			}
			//colors
			{
				colors = new String[]{"Grey",
						"Core Black",
						"Triple Black",
						"Black",
						"Core Black, Icy Blue"};
			}
			//prices
			{
				prices = new double[]{28900,
						9900,
						12900,
						399,
						7990};
			}
		}
		for (int i = 0; i < productnames.length; i++) {
			if (descriptions[i].length() >= 100){
				description = descriptions[i].substring(0,100);
			}else{
				description = descriptions[i];
			}
			productService.registerProduct(productnames[i],
					description,
					brands[i],
					colors[i],
					prices[i]);
		}

	}


	public static void main(String[] args) {
		SpringApplication.run(ShooopieApplication.class, args);
	}

}
