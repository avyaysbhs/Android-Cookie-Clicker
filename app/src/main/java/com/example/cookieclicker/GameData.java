package com.example.cookieclicker;

import java.io.Serializable;

public class GameData implements Serializable
{
    public final static long serialVersionUID = 1000L;
    public float gold;
    public ProductionAsset[] assets;
}
