package md.task.rest;

import md.task.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyResource {
    @Autowired
    private GeoService geoService;

    @RequestMapping(value = "/ifNear/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkIfNear(@PathVariable("userId") Long userId, @RequestParam("lat") Float lat, @RequestParam("lon") Float lon, @RequestParam("dumb") boolean dumb){
        return geoService.findIfNear(userId, lat, lon);

    }
    @RequestMapping(value = "/labels/count", method = RequestMethod.GET)
    @ResponseBody
    public long labelsCount(@RequestParam("lat") Float lat, @RequestParam("lon") Float lon){
        return geoService.labelsCount(lat, lon);

    }
}
