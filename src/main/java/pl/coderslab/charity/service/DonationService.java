package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;

@Service
public interface DonationService {

    int sumOfBags();
    long sumOfDonations();
    void addDonations(Donation donation);
}
