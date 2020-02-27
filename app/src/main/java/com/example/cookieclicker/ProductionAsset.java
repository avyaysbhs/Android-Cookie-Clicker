package com.example.cookieclicker;

import java.util.HashMap;

@SuppressWarnings("WeakerAccess")
public class ProductionAsset {
    final String name;
    final float rate;
    final float clickPower;
    final float cost;

    static final int FACTORY_ASSET = 0;
    static final int CLICK_ASSET = 1;

    @AssetType final int type;

    final static HashMap<String, ProductionAsset> factoriesForSale = new HashMap<>();
    final static HashMap<String, ProductionAsset> clickersForSale = new HashMap<>();

    static {
        new ProductionAsset("Gold Miner", 3f, 0f, 60, FACTORY_ASSET);
        new ProductionAsset("Gold Mine", 30f, 0f, 100, FACTORY_ASSET);
        new ProductionAsset("Village of Miners", 150f, 0f, 300, FACTORY_ASSET);

        new ProductionAsset("Wooden Pickaxe", 0f, .2f, 10, CLICK_ASSET);
        new ProductionAsset("Stone Pickaxe", 0f, .3f, 40, CLICK_ASSET);
        new ProductionAsset("Sturdy Stone Pickaxe", 0f, .7f, 60, CLICK_ASSET);
        new ProductionAsset("Stainless Steel Pickaxe", 0f, 1f, 140, CLICK_ASSET);
        new ProductionAsset("Iron Pickaxe", 0f, 3f, 500, CLICK_ASSET);
        new ProductionAsset("Diamond Pickaxe", 0f, 10f, 1500, CLICK_ASSET);
        new ProductionAsset("Giant Stone Hammer", 0f, 20f, 5000, CLICK_ASSET);
        //noinspection SpellCheckingInspection
        new ProductionAsset("Pick-Axcalibur", 0f, 250f, 50000, CLICK_ASSET);
    }

    private ProductionAsset(String name, float rate, float clickPower, float cost, @AssetType int type)
    {
        this.name = name;
        this.rate = rate;
        this.clickPower = clickPower;
        this.cost = cost;
        this.type = type;

        switch (type)
        {
            case FACTORY_ASSET:
                factoriesForSale.put(this.name, this);
                break;
            case CLICK_ASSET:
                clickersForSale.put(this.name, this);
                break;
        }
    }
}
