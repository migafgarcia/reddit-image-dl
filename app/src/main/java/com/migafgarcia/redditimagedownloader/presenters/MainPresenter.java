package com.migafgarcia.redditimagedownloader.presenters;

import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.services.RedditApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private static final String TAG = MainPresenter.class.getName();
    private final MainScreen mainScreen;
    private final RedditApi redditApi;

    private final String multireddit = "oldschoolcool+thewaywewere+pic+pics+AbandonedPorn+EarthPorn+MilitaryPorn+BotanicalPorn+waterporn+SeaPorn+SkyPorn+FirePorn+DesertPorn+WinterPorn+AutumnPorn+WeatherPorn+GeologyPorn+SpacePorn+BeachPorn+MushroomPorn+SpringPorn+SummerPorn+LavaPorn+LakePorn+CityPorn+VillagePorn+RuralPorn+ArchitecturePorn+HousePorn+CabinPorn+ChurchPorn+AbandonedPorn+CemeteryPorn+InfrastructurePorn+MachinePorn+CarPorn+F1Porn+MotorcyclePorn+MilitaryPorn+GunPorn+KnifePorn+BoatPorn+RidesPorn+DestructionPorn+ThingsCutInHalfPorn+StarshipPorn+ToolPorn+TechnologyPorn+BridgePorn+PolicePorn+SteamPorn+RetailPorn+SpaceFlightPorn+roadporn+drydockporn+AnimalPorn+HumanPorn+EarthlingPorn+AdrenalinePorn+ClimbingPorn+SportsPorn+AgriculturePorn+TeaPorn+BonsaiPorn+FoodPorn+CulinaryPorn+DessertPorn+DesignPorn+RoomPorn+AlbumArtPorn+MetalPorn+MoviePosterPorn+TelevisionPosterPorn+ComicBookPorn+StreetArtPorn+AdPorn+ArtPorn+FractalPorn+InstrumentPorn+ExposurePorn+MacroPorn+MicroPorn+GeekPorn+MTGPorn+GamerPorn+PowerWashingPorn+AerialPorn+OrganizationPorn+FashionPorn+AVPorn+ApocalypsePorn+InfraredPorn+ViewPorn+HellscapePorn+sculptureporn+HistoryPorn+UniformPorn+BookPorn+NewsPorn+QuotesPorn+FuturePorn+FossilPorn+MegalithPorn+ArtefactPorn+wallpaper+wallpapers+iWallpaper+Verticalwallpapers";


    public MainPresenter(MainScreen mainScreen, RedditApi redditApi) {
        this.mainScreen = mainScreen;
        this.redditApi = redditApi;
    }

    public void getPosts() {

        mainScreen.showLoading();

        // TODO: 21-08-2017 fetch subreddits from sqlite
        redditApi.getService().getList(multireddit).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {
                if (response.isSuccessful()) {
                    mainScreen.getPosts(response.body());
                } else
                    mainScreen.showGetRetry();

                mainScreen.hideLoading();
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {
                mainScreen.showGetRetry();
                mainScreen.hideLoading();

            }
        });
    }


    public void morePosts(final String after) {
        mainScreen.showLoading();
        redditApi.getService().getListAfter(multireddit, after).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {
                if (response.isSuccessful()) {
                    mainScreen.getPosts(response.body());
                } else
                    mainScreen.showGetRetry(); // TODO: 18-09-2017 after must be passed here

                mainScreen.hideLoading();
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {
                mainScreen.showGetRetry();
                mainScreen.hideLoading();

            }
        });
    }
}
