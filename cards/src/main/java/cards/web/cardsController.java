package cards.web;


import cards.config.CardsServiceConfig;
import cards.models.Cards;
import cards.models.Customer;
import cards.models.Properties;
import cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class cardsController {

    private final CardsRepository cardsRepository;

     private final CardsServiceConfig cardsServiceConfig;

    public cardsController(CardsRepository cardsRepository, CardsServiceConfig cardsServiceConfig) {
        this.cardsRepository = cardsRepository;
        this.cardsServiceConfig = cardsServiceConfig;
    }


    @PostMapping("/myCards")
    public List<Cards> cardsList(@RequestBody Customer customer){

        return cardsRepository.findByCustomerId(customer.getCustomerId());
    }


    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsServiceConfig.getMsg(),cardsServiceConfig.getBuildVersion(),
                cardsServiceConfig.getMailDetails(),cardsServiceConfig.getActiveBranches());

        String jsonStr = ow.writeValueAsString(properties);
        return  jsonStr;
    }

}

