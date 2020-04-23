package com.demo.rent;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(path = "/v1")
public class RentController {

    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;

    public RentController(EurekaClient eurekaClient, RestTemplate restTemplate) {
        this.eurekaClient = eurekaClient;
        this.restTemplate = restTemplate;
    }
	
    @RequestMapping(path = "/rentals/{id}/charges", method = RequestMethod.GET)
    public ResponseEntity getPossibleCharges(@PathVariable("id") String id) {
    	 eurekaClient.getApplications();
         Iterator i = eurekaClient.getApplications().getRegisteredApplications().iterator();

         while (i.hasNext()) {
             Application app = (Application) i.next();
             System.out.println(app.getName());
         }
         
         InstanceInfo instance = eurekaClient.getNextServerFromEureka("pricing-service", false);
         ZonedDateTime startTime = ZonedDateTime.now();
         ZonedDateTime endTime = startTime.plus(2, ChronoUnit.DAYS);
         HttpEntity<PriceRequest> request = new HttpEntity<>(
                 new PriceRequest("vip", startTime, endTime)
         );
         PriceResponse response = restTemplate.postForObject(
             instance.getHomePageUrl() + "/v1/prices", request, PriceResponse.class);
         return new ResponseEntity<>(new RentChargesResponse(response.getPrice()), HttpStatus.OK);
         
    }
    
}
