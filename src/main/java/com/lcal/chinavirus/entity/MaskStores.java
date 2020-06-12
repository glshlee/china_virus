package com.lcal.chinavirus.entity;

import java.util.List;
import lombok.Getter;

@Getter
public class MaskStores {
    private int count;
    private int page;

    private List<MaskStore> storeInfos;
}
