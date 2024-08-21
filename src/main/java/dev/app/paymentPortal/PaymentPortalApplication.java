package dev.app.paymentPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentPortalApplication.class, args);
	}


	//!!!!   Sa fac UtilityPrice in loc de un ID sa aiba nume ca ID de ex:
	// /utilityPrice/water
	// /utilityPrice/gas
	// /utilityPrice/electricity
	// si asa avem numai maxim 3 obiecte in clasa aia sa nu fie mai multe.

}
