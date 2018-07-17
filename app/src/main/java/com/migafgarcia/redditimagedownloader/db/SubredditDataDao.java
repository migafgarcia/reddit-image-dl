package com.migafgarcia.redditimagedownloader.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Collection;
import java.util.List;

/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
@android.arch.persistence.room.Dao
public interface SubredditDataDao {

    String[] DEFAULT_SUBREDDITS = {"oldschoolcool", "thewaywewere", "pic", "pics", "AbandonedPorn", "EarthPorn", "MilitaryPorn", "BotanicalPorn", "waterporn", "SeaPorn", "SkyPorn", "FirePorn", "DesertPorn", "WinterPorn", "AutumnPorn", "WeatherPorn", "GeologyPorn", "SpacePorn", "BeachPorn", "MushroomPorn", "SpringPorn", "SummerPorn", "LavaPorn", "LakePorn", "CityPorn", "VillagePorn", "RuralPorn", "ArchitecturePorn", "HousePorn", "CabinPorn", "ChurchPorn", "AbandonedPorn", "CemeteryPorn", "InfrastructurePorn", "MachinePorn", "CarPorn", "F1Porn", "MotorcyclePorn", "MilitaryPorn", "GunPorn", "KnifePorn", "BoatPorn", "RidesPorn", "DestructionPorn", "ThingsCutInHalfPorn", "StarshipPorn", "ToolPorn", "TechnologyPorn", "BridgePorn", "PolicePorn", "SteamPorn", "RetailPorn", "SpaceFlightPorn", "roadporn", "drydockporn", "AnimalPorn", "HumanPorn", "EarthlingPorn", "AdrenalinePorn", "ClimbingPorn", "SportsPorn", "AgriculturePorn", "TeaPorn", "BonsaiPorn", "FoodPorn", "CulinaryPorn", "DessertPorn", "DesignPorn", "RoomPorn", "AlbumArtPorn", "MetalPorn", "MoviePosterPorn", "TelevisionPosterPorn", "ComicBookPorn", "StreetArtPorn", "AdPorn", "ArtPorn", "FractalPorn", "InstrumentPorn", "ExposurePorn", "MacroPorn", "MicroPorn", "GeekPorn", "MTGPorn", "GamerPorn", "PowerWashingPorn", "AerialPorn", "OrganizationPorn", "FashionPorn", "AVPorn", "ApocalypsePorn", "InfraredPorn", "ViewPorn", "HellscapePorn", "sculptureporn", "HistoryPorn", "UniformPorn", "BookPorn", "NewsPorn", "QuotesPorn", "FuturePorn", "FossilPorn", "MegalithPorn", "ArtefactPorn", "wallpaper", "wallpapers", "iWallpaper", "Verticalwallpapers"};

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SubredditData subredditData);

    @Delete
    void delete(SubredditData subredditData);

    @Query("SELECT * FROM subredditdata")
    LiveData<List<SubredditData>> getSubreddits();


}
