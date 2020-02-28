package com.example.cookieclicker;

import androidx.annotation.DrawableRes;

import java.io.Serializable;
import java.util.LinkedHashMap;

@SuppressWarnings("WeakerAccess")
public class ProductionAsset implements Serializable {
    public final static long serialVersionUID = 1000L;

    final String name;
    final float rate;
    final float clickPower;
    final float cost;

    static final int FACTORY_ASSET = 0;
    static final int CLICK_ASSET = 1;

    @AssetType final int type;
    @DrawableRes final int imageResId;

    final static LinkedHashMap<String, ProductionAsset> factoriesForSale = new LinkedHashMap<>();
    final static LinkedHashMap<String, ProductionAsset> clickersForSale = new LinkedHashMap<>();

    static {
        new ProductionAsset("Gold Miner", 3f, 0f, 60, FACTORY_ASSET, R.mipmap.miner_foreground);
        new ProductionAsset("Gold Mine", 30f, 0f, 100, FACTORY_ASSET, R.mipmap.mine_foreground);
        new ProductionAsset("Village of Miners", 150f, 0f, 300, FACTORY_ASSET, R.mipmap.minervillage_foreground);
        new ProductionAsset("TNT", 250f, 25f, 15500, FACTORY_ASSET, R.mipmap.tnt_foreground);

        new ProductionAsset("Wooden Pickaxe", 0f, .2f, 10, CLICK_ASSET, R.mipmap.woodenaxe_foreground);
        new ProductionAsset("Stone Pickaxe", 0f, .3f, 40, CLICK_ASSET, R.mipmap.stoneaxe_foreground);
        new ProductionAsset("Sturdy Stone Pickaxe", 0f, .7f, 60, CLICK_ASSET, R.mipmap.sturdystoneaxe_foreground);
        new ProductionAsset("Stainless Steel Pickaxe", 0f, 5f, 140, CLICK_ASSET, R.mipmap.stainlesssteelaxe_foreground);
        new ProductionAsset("Iron Pickaxe", 0f, 20f, 500, CLICK_ASSET, R.mipmap.ironaxe_foreground);
        new ProductionAsset("Diamond Pickaxe", 0f, 50f, 1500, CLICK_ASSET, R.mipmap.diamondaxe_foreground);
        new ProductionAsset("Giant Stone Hammer", 0f, 100f, 5000, CLICK_ASSET, R.mipmap.stonehammer_foreground);
        //noinspection SpellCheckingInspection
        new ProductionAsset("Pick-Axcalibur", 0f, 1050f, 50000, CLICK_ASSET, R.mipmap.goldaxe_foreground);
    }

    private ProductionAsset(String name, float rate, float clickPower, float cost, @AssetType int type, int imageResId)
    {
        this.name = name;
        this.rate = rate;
        this.clickPower = clickPower;
        this.cost = cost;
        this.type = type;
        this.imageResId = imageResId;

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
