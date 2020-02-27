package com.example.cookieclicker;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static com.example.cookieclicker.ProductionAsset.*;

@Retention(SOURCE)
@IntDef({FACTORY_ASSET, CLICK_ASSET})
public @interface AssetType {}