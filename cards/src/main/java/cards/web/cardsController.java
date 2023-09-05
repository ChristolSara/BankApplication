package cards.web;


import cards.models.Cards;
import cards.models.Customer;
import cards.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class cardsController {

    private CardsRepository cardsRepository;


   @PostMapping("/cardsList")
    public List<Cards> cardsList(@RequestBody Customer customer){

        return cardsRepository.findByCustomerId(customer.getCustomerId());
    }

}

