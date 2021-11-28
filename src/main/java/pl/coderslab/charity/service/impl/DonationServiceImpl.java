package pl.coderslab.charity.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {
    public final DonationRepository donationRepository;

    public int sumOfBags(){
        return donationRepository.findAll()
                .stream()
                .mapToInt(Donation::getQuantity)
                .sum();
    }

    public long sumOfDonations(){
        return donationRepository.count();
    }

    public void addDonations(Donation donation){donationRepository.save(donation);}
}
