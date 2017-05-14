package by.netcracker.hotel.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.HotelService;

/**
 * Created by Varvara on 4/8/2017.
 */

@Service("HotelServiceImpl")
@SessionScope
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;
    private final RoomDAO roomDAO;

    @Override
    public Hotel getByID(Integer id) {
        Hotel hotel = hotelDAO.getByID(id);
        return hotel;
    }

    @Autowired
    public HotelServiceImpl(HotelDAO hotelDAO, RoomDAO roomDAO) {
        this.hotelDAO = hotelDAO;
        this.roomDAO = roomDAO;
    }

    /*
     * @Override public Map<Hotel, List<Room>> findHotels(List<String>
     * searchStrings, String start, String end) { List<Hotel> hotels =
     * hotelDAO.findHotelsBySearchStrings(searchStrings); Map<Hotel, List<Room>>
     * hotelsWithRooms = new HashMap<>(); SimpleDateFormat dateFormat = new
     * SimpleDateFormat("MM/dd/yyyy"); if (!StringUtils.isBlank(start) &&
     * !StringUtils.isBlank(end)) { for (Hotel hotel : hotels) { try {
     * hotelsWithRooms.put(hotel,
     * roomDAO.getFreeRoomsInHotelByDate(hotel.getId(), dateFormat.parse(start),
     * dateFormat.parse(end))); } catch (ParseException e) { return null; } } }
     * else { for (Hotel hotel : hotels) { hotelsWithRooms.put(hotel,
     * roomDAO.getByHotelID(hotel.getId())); } } return hotelsWithRooms; }
     */
    @Override
    public Map<Hotel, List<Room>> findHotels(List<String> searchStrings, SearchFilter searchFilter) {
        List<Hotel> hotels = hotelDAO.findHotelsBySearchStrings(searchStrings, searchFilter);
        Map<Hotel, List<Room>> hotelsWithRooms = new HashMap<>();
        for (Hotel hotel : hotels) {
            hotelsWithRooms.put(hotel, roomDAO.getFreeRoomsInHotelByDate(searchFilter, hotel.getId()));
        }
        return hotelsWithRooms;
    }


    @Override
    public List<Hotel> getAll() {
        return hotelDAO.getAll();
    }

    @Override
    public List<String> getPlaces() {
        return hotelDAO.getPlaces();
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotel.setEnabled(true);
        hotelDAO.add(hotel);
    }

    @Override
    public List<String> getHotelNames() {
        return hotelDAO.getHotelNames();
    }

    @Override
    public void addPhoto(String photo, int hotelID) {
        hotelDAO.addPhoto(photo, hotelID);
    }

}
