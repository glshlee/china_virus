package com.lcal.chinavirus.service.impl;

import java.util.List;
import com.lcal.chinavirus.entity.MaskStore;
import com.lcal.chinavirus.entity.MaskStores;
import com.lcal.chinavirus.service.Covid19MaskStoreService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19MaskStoreFromDataPortalService implements Covid19MaskStoreService {

    private static final String URI = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json";

    @Override
    public List<MaskStore> getAllMaskStore() {
        return callAllMaskStoreJsonString().getStoreInfos();
    }

    private MaskStores callAllMaskStoreJsonString() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URI, MaskStores.class);
    }


    
    
}