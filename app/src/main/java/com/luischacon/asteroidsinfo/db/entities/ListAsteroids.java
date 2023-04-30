//package com.luischacon.asteroidsinfo.db.entities;
//
//import java.util.List;
//
//public class ListAsteroids {
//
//    public List<Asteroid> getAsteroids() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.nasa.gov/neo/rest/v1/feed?start_date=2023-04-28&end_date=2023-04-29&api_key=DEMO_KEY")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        String jsonResponse = response.body().string();
//
//        Gson gson = new Gson();
//        JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);
//        JsonObject asteroidData = json.getAsJsonObject("near_earth_objects").getAsJsonObject("2023-04-28");
//
//        List<Asteroid> asteroids = new ArrayList<>();
//
//        for (JsonElement element : asteroidData.getAsJsonArray()) {
//            JsonObject asteroidJson = element.getAsJsonObject();
//
//            Asteroid asteroid = new Asteroid();
//            asteroid.name = asteroidJson.get("name").getAsString();
//            asteroid.is_potentially_hazardous_asteroid = asteroidJson.get("is_potentially_hazardous_asteroid").getAsBoolean();
//            asteroid.orbiting_body = asteroidJson.get("close_approach_data").getAsJsonArray().get(0).getAsJsonObject().get("orbiting_body").getAsString();
//            asteroid.estimated_diameter_min = asteroidJson.getAsJsonObject("estimated_diameter").getAsJsonObject("kilometers").get("estimated_diameter_min").getAsDouble();
//            asteroid.estimated_diameter_max = asteroidJson.getAsJsonObject("estimated_diameter").getAsJsonObject("kilometers").get("estimated_diameter_max").getAsDouble();
//            asteroid.kilometers_per_second = asteroidJson.getAsJsonObject("close_approach_data").getAsJsonArray().get(0).getAsJsonObject().getAsJsonObject("relative_velocity").get("kilometers_per_second").getAsDouble();
//
//            asteroids.add(asteroid);
//        }
//
//        return asteroids;
//    }
//}
