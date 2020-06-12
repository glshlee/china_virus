package com.lcal.chinavirus.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import com.lcal.chinavirus.entity.MaskStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Covid19MaskStoreFromDataPortalTest {
    @Autowired
    private Covid19MaskStoreFromDataPortalService maskStoreService;

    @Test
    public void givenValidRequst_whenGetMaskStore_thenReturnValidResponse() {
        // given

        // when
        List<MaskStore> maskStores = maskStoreService.getMaskStore();

        // then
        assertNotEquals(0, maskStores.size());
    }
}