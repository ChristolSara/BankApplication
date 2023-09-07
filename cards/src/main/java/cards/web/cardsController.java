package cards.web;


import cards.config.CardsServiceConfig;
import cards.models.Cards;
import cards.models.Customer;
import cards.models.Properties;
import cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor @NoArgsConstructor
public class cardsController {

    private CardsRepository cardsRepository;
    @Autowired
     CardsServiceConfig cardsServiceConfig;


   @PostMapping("/cardsList")
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

