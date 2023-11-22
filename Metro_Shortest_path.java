import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MetroShortestpath {
    static class Station {
        String name;
        List<String> timings;
        Map<Station, Integer> neighbors;

        Station(String name) {
            this.name = name;
            this.timings = new ArrayList<>();
            this.neighbors = new HashMap<>();
        }

        void addNeighbor(Station neighbor, int time) {
            neighbors.put(neighbor, time);
        }
        
        void addTiming(String timing) {
            timings.add(timing);
        }

        public String toString() {
            return name;
        }
    }

    private static Station findStationByName(String stationName, List<Station> allStations) {
        for (Station station : allStations) {
            if (station.name.equalsIgnoreCase(stationName)) {
                return station;
            }
        }
        return null;
    }

    public static List<Station> dijkstra(Station start, Station end) {
       Map<Station, Integer> distances = new HashMap<>();
       Map<Station, Station> previousStations = new HashMap<>();
       PriorityQueue<Station> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
       distances.put(start, 0);
       queue.add(start);

       while (!queue.isEmpty()) {
           Station current = queue.poll();

           if (current == end) {
               break;  
           }

           for (Map.Entry<Station, Integer> neighborEntry : current.neighbors.entrySet()) {
               Station neighbor = neighborEntry.getKey();
               int timeToNeighbor = distances.get(current) + neighborEntry.getValue();

               if (timeToNeighbor < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                   distances.put(neighbor, timeToNeighbor);
                   previousStations.put(neighbor, current);
                   queue.add(neighbor);
               }
           }
       }

       if (!previousStations.containsKey(end)) {
           return null;  
       }
        
       List<Station> path = new ArrayList<>();
       Station current = end;
       while (current != null) {
           path.add(current);
           current = previousStations.get(current);
       }

       Collections.reverse(path);
       return path;
    }

    public static void main(String[] args) {
        List<Station> allStations = new ArrayList<>();
       
        Station startStation = null;
        Station endStation = null;

        Scanner sc = new Scanner(System.in);
        Station millennium_city_centre = new Station("millenium_city_centre");
        Station iffco_chowk = new Station("iffco_chowk");
        Station mg_road = new Station("mg_road");
        Station sikanderpur = new Station("sikanderpur");
        Station guru_dronacharya = new Station("guru_dronacharya");
        Station arjan_garh = new Station("arjan_garh");
        Station ghitorni = new Station("ghitorni");
        Station sultanpur = new Station("sultanpur");
        Station chattarpur = new Station("chattarpur");
        Station qutab_minar = new Station("qutab_minar");
        Station saket = new Station("saket");
        Station malviya_nagar = new Station("malviya_nagar");
        Station hauz_khas = new Station("hauz_khas");
        Station green_park = new Station("green_park");
        Station aiims = new Station("aiims");
        Station ina = new Station("ina");
        Station jor_bagh = new Station("jor_bagh");
        Station lok_kalyan_marg = new Station("lok_kalyan_marg");
        Station udyog_bhawan = new Station("udyog_bhawan");
        Station central_secretariat = new Station("central_secretariat");
        Station patel_chowk = new Station("patel_chowk");
        Station rajiv_chowk = new Station("rajiv_chowk");
        Station new_delhi = new Station("new_delhi");
        Station chawri_bazar = new Station("chawri_bazar");
        Station chandni_chowk = new Station("chandni_chowk");
        Station kashmere_gate = new Station("kashmere_gate");
        Station civil_lines = new Station("civil_lines");
        Station vidhan_sabha = new Station("vidhan_sabha");
        Station vishwavidyalaya = new Station("vishwavidyalaya");
        Station gtb_nagar = new Station("gtb_nagar");
        Station model_town = new Station("model_town");
        Station adarsh_nagar = new Station("adarsh_nagar");
        Station jahangiripuri = new Station("jahangiripuri");
        Station phase1 = new Station("phase1");
        Station phase2 = new Station("phase2");
        Station phase3 = new Station("phase3");
        Station moulsari_avenue = new Station("moulsari_avenue");
        Station belvedere_towers = new Station("belvedere_towers");
        Station sec42_43 = new Station("sec42-43");
        Station cyber_city = new Station("cyber_city");
        Station sec53_54 = new Station("sec53_54");
        Station sec54 = new Station("sec54");
        Station sec55_56 = new Station("sec55_56");
        Station dwarka = new Station("dwarka");
        Station dwarka_sec21 = new Station("dwarka_sec_21");
        Station dwarka_sec8 = new Station("dwarka_sec8");
        Station dwarka_sec9 = new Station("dwarka_sec9");
        Station dwarka_sec10 = new Station("dwarka_sec10");
        Station dwarka_sec11 = new Station("dwarka_sec11");
        Station dwarka_sec12 = new Station("dwarka_sec12");
        Station dwarka_sec13 = new Station("dwarka_sec13");
        Station dwarka_sec14 = new Station("dwarka_sec14");
        Station dwarka_mor = new Station("dwarka_mor");
        Station nawada = new Station("nawada");
        Station uttam_nagar_west = new Station("uttam_nagar_west");
        Station uttam_nagar_east = new Station("uttam_nagar_east");
        Station janakpuri_west = new Station("janakpuri_west");
        Station janakpuri_east = new Station("janakpuri_east");
        Station tilak_nagar = new Station("tilak_nagar");
        Station subhash_nagar = new Station("subhash_nagar");
        Station tagore_garden = new Station("tagore_garden");
        Station rajouri_garden = new Station("rajouri_garden");
        Station ramesh_nagar = new Station("ramesh_nagar");
        Station moti_nagar = new Station("moti_nagar");
        Station kirti_nagar = new Station("kirti_nagar");
        Station shadipur = new Station("shadipur");
        Station patel_nagar = new Station("patel_nagar");
        Station rajendra_palace = new Station("rajendra_palace");
        Station karol_bagh = new Station("karol_bagh");
        Station jhandewalan = new Station("jhandewalan");
        Station ra_marg = new Station("ra_marg");
        Station barakhamba_road = new Station("barakhamba_road");
        Station mandi_house = new Station("mandi_house");
        Station supreme_court = new Station("supreme_court");
        Station yamuna_bank = new Station("yamuna_bank");
        Station laxmi_nagar = new Station("laxmi_nagar");
        Station nirman_vihar = new Station("nirman_vihar");
        Station preet_vihar = new Station("preet_vihar");
        Station karkarduma = new Station("karkarduma");
        Station anand_vihar = new Station("anand_vihar");
        Station kaushambi = new Station("kaushambi");
        Station vaishali = new Station("vaishali");
        Station dabri_mor = new Station("dabro_mor");
        Station dashrathpuri = new Station("dashrathpuri");
        Station palam = new Station("palam");
        Station sadar_bazar = new Station("sadar_bazar");
        Station igi_t1 = new Station("IGI_terminal_1");
        Station shankar_vihar = new Station("shankar_vihar");
        Station vasant_vihar = new Station("vasant_vihar");
        Station munirka = new Station("munirka");
        Station rk_puram = new Station("RK_Puram");
        Station iit = new Station("IIT");
        Station panchsheel = new Station("panchsheel");
        Station chirag_delhi = new Station("chirag_delhi");
        Station grater_kailash = new Station("grater_kailash");
        Station nehru_enclave = new Station("nehru_enclave");
        Station kalka_ji = new Station("kalka_ji_mandir");
        Station okhla = new Station("okhla");
        Station sukhdev_vihar = new Station("sukhdev_vihar");
        Station jamia_milia_islamia = new Station("jamia_milia_islamia");
        Station okhla_vihar = new Station("okhla_vihar");
        Station jasola_vihar = new Station("jasola_vihar");
        Station kalindi_kunj = new Station("kalindi_kunj");
        Station okhla_bird_sanctuary = new Station("okhla_bird_sanctuary");
        Station botanical_garden = new Station("botanical_garden");

        // Add stations to the allStations list
        allStations.add(millennium_city_centre);
        allStations.add(iffco_chowk);
        allStations.add(mg_road);
        allStations.add(sikanderpur);
        allStations.add(guru_dronacharya);
        allStations.add(arjan_garh);
        allStations.add(ghitorni);
        allStations.add(sultanpur);
        allStations.add(chattarpur);
        allStations.add(qutab_minar);
        allStations.add(saket);
        allStations.add(malviya_nagar);
        allStations.add(hauz_khas);
        allStations.add(green_park);
        allStations.add(aiims);
        allStations.add(ina);
        allStations.add(jor_bagh);
        allStations.add(lok_kalyan_marg);
        allStations.add(udyog_bhawan);
        allStations.add(central_secretariat);
        allStations.add(patel_chowk);
        allStations.add(rajiv_chowk);
        allStations.add(new_delhi);
        allStations.add(chawri_bazar);
        allStations.add(chandni_chowk);
        allStations.add(kashmere_gate);
        allStations.add(civil_lines);
        allStations.add(vidhan_sabha);
        allStations.add(vishwavidyalaya);
        allStations.add(gtb_nagar);
        allStations.add(model_town);
        allStations.add(adarsh_nagar);
        allStations.add(jahangiripuri);
        allStations.add(phase1);
        allStations.add(phase2);
        allStations.add(phase3);
        allStations.add(moulsari_avenue);
        allStations.add(belvedere_towers);
        allStations.add(sec42_43);
        allStations.add(cyber_city);
        allStations.add(sec53_54);
        allStations.add(sec54);
        allStations.add(sec55_56);
        allStations.add(dwarka);
        allStations.add(dwarka_sec21);
        allStations.add(dwarka_sec8);
        allStations.add(dwarka_sec9);
        allStations.add(dwarka_sec10);
        allStations.add(dwarka_sec11);
        allStations.add(dwarka_sec12);
        allStations.add(dwarka_sec13);
        allStations.add(dwarka_sec14);
        allStations.add(dwarka_mor);
        allStations.add(nawada);
        allStations.add(uttam_nagar_west);
        allStations.add(janakpuri_west);
        allStations.add(janakpuri_east);
        allStations.add(tilak_nagar);
        allStations.add(subhash_nagar);
        allStations.add(tagore_garden);
        allStations.add(rajouri_garden);
        allStations.add(ramesh_nagar);
        allStations.add(moti_nagar);
        allStations.add(kirti_nagar);
        allStations.add(shadipur);
        allStations.add(patel_nagar);
        allStations.add(rajendra_palace);
        allStations.add(karol_bagh);
        allStations.add(jhandewalan);
        allStations.add(ra_marg);
        allStations.add(barakhamba_road);
        allStations.add(mandi_house);
        allStations.add(supreme_court);
        allStations.add(yamuna_bank);
        allStations.add(laxmi_nagar);
        allStations.add(nirman_vihar);
        allStations.add(preet_vihar);
        allStations.add(karkarduma);
        allStations.add(anand_vihar);
        allStations.add(kaushambi);
        allStations.add(vaishali);
        allStations.add(dashrathpuri);
        allStations.add(palam);
        allStations.add(sadar_bazar);
        allStations.add(vasant_vihar);
        allStations.add(munirka);
        allStations.add(chirag_delhi);
        allStations.add(nehru_enclave);
        allStations.add(okhla);
        allStations.add(sukhdev_vihar);
        allStations.add(jamia_milia_islamia);
        allStations.add(okhla_vihar);
        allStations.add(jasola_vihar);
        allStations.add(kalindi_kunj);
        allStations.add(okhla_bird_sanctuary);
        allStations.add(botanical_garden);
        
        millennium_city_centre.addTiming("6:00 AM - 10:00 PM");
        iffco_chowk.addTiming("6:00 AM - 10:00 PM");
        mg_road.addTiming("6:00 AM - 10:00 PM");
        sikanderpur.addTiming("6:00 AM - 10:00 PM");
        guru_dronacharya.addTiming("6:00 AM - 10:00 PM");
        arjan_garh.addTiming("6:00 AM - 10:00 PM");
        ghitorni.addTiming("6:00 AM - 10:00 PM");
        sultanpur.addTiming("6:00 AM - 10:00 PM");
        chattarpur.addTiming("6:00 AM - 10:00 PM");
        qutab_minar.addTiming("6:00 AM - 10:00 PM");
        saket.addTiming("6:00 AM - 10:00 PM");
        malviya_nagar.addTiming("6:00 AM - 10:00 PM");
        hauz_khas.addTiming("6:00 AM - 10:00 PM");
        green_park.addTiming("6:00 AM - 10:00 PM");
        aiims.addTiming("6:00 AM - 10:00 PM");
        ina.addTiming("6:00 AM - 10:00 PM");
        jor_bagh.addTiming("6:00 AM - 10:00 PM");
        lok_kalyan_marg.addTiming("6:00 AM - 10:00 PM");
        udyog_bhawan.addTiming("6:00 AM - 10:00 PM");
        central_secretariat.addTiming("6:00 AM - 10:00 PM");
        patel_chowk.addTiming("6:00 AM - 10:00 PM");
        rajiv_chowk.addTiming("6:00 AM - 10:00 PM");
        new_delhi.addTiming("6:00 AM - 10:00 PM");
        chawri_bazar.addTiming("6:00 AM - 10:00 PM");
        chandni_chowk.addTiming("6:00 AM - 10:00 PM");
        kashmere_gate.addTiming("6:00 AM - 10:00 PM");
        civil_lines.addTiming("6:00 AM - 10:00 PM");
        vidhan_sabha.addTiming("6:00 AM - 10:00 PM");
        vishwavidyalaya.addTiming("6:00 AM - 10:00 PM");
        gtb_nagar.addTiming("6:00 AM - 10:00 PM");
        model_town.addTiming("6:00 AM - 10:00 PM");
        adarsh_nagar.addTiming("6:00 AM - 10:00 PM");
        jahangiripuri.addTiming("6:00 AM - 10:00 PM");
        phase1.addTiming("6:00 AM - 10:00 PM");
        phase2.addTiming("6:00 AM - 10:00 PM");
        phase3.addTiming("6:00 AM - 10:00 PM");
        moulsari_avenue.addTiming("6:00 AM - 10:00 PM");
        belvedere_towers.addTiming("6:00 AM - 10:00 PM");
        sec42_43.addTiming("6:00 AM - 10:00 PM");
        cyber_city.addTiming("6:00 AM - 10:00 PM");
        sec53_54.addTiming("6:00 AM - 10:00 PM");
        sec55_56.addTiming("6:00 AM - 10:00 PM");
        dwarka.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec21.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec8.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec9.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec10.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec11.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec12.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec13.addTiming("6:00 AM - 10:00 PM");
        dwarka_sec14.addTiming("6:00 AM - 10:00 PM");
        dwarka_mor.addTiming("6:00 AM - 10:00 PM");
        nawada.addTiming("6:00 AM - 10:00 PM");
        uttam_nagar_west.addTiming("6:00 AM - 10:00 PM");
        janakpuri_west.addTiming("6:00 AM - 10:00 PM");
        janakpuri_east.addTiming("6:00 AM - 10:00 PM");
        tilak_nagar.addTiming("6:00 AM - 10:00 PM");
        subhash_nagar.addTiming("6:00 AM - 10:00 PM");
        tagore_garden.addTiming("6:00 AM - 10:00 PM");
        rajouri_garden.addTiming("6:00 AM - 10:00 PM");
        ramesh_nagar.addTiming("6:00 AM - 10:00 PM");
        moti_nagar.addTiming("6:00 AM - 10:00 PM");
        kirti_nagar.addTiming("6:00 AM - 10:00 PM");
        shadipur.addTiming("6:00 AM - 10:00 PM");
        patel_nagar.addTiming("6:00 AM - 10:00 PM");
        rajendra_palace.addTiming("6:00 AM - 10:00 PM");
        karol_bagh.addTiming("6:00 AM - 10:00 PM");
        jhandewalan.addTiming("6:00 AM - 10:00 PM");
        ra_marg.addTiming("6:00 AM - 10:00 PM");
        barakhamba_road.addTiming("6:00 AM - 10:00 PM");
        mandi_house.addTiming("6:00 AM - 10:00 PM");
        supreme_court.addTiming("6:00 AM - 10:00 PM");
        yamuna_bank.addTiming("6:00 AM - 10:00 PM");
        laxmi_nagar.addTiming("6:00 AM - 10:00 PM");
        nirman_vihar.addTiming("6:00 AM - 10:00 PM");
        preet_vihar.addTiming("6:00 AM - 10:00 PM");
        karkarduma.addTiming("6:00 AM - 10:00 PM");
        anand_vihar.addTiming("6:00 AM - 10:00 PM");
        kaushambi.addTiming("6:00 AM - 10:00 PM");
        vaishali.addTiming("6:00 AM - 10:00 PM");
        dashrathpuri.addTiming("6:00 AM - 10:00 PM");
        palam.addTiming("6:00 AM - 10:00 PM");
        sadar_bazar.addTiming("6:00 AM - 10:00 PM");
        vasant_vihar.addTiming("6:00 AM - 10:00 PM");
        munirka.addTiming("6:00 AM - 10:00 PM");
        chirag_delhi.addTiming("6:00 AM - 10:00 PM");
        nehru_enclave.addTiming("6:00 AM - 10:00 PM");
        okhla.addTiming("6:00 AM - 10:00 PM");
        sukhdev_vihar.addTiming("6:00 AM - 10:00 PM");
        jamia_milia_islamia.addTiming("6:00 AM - 10:00 PM");
        okhla_vihar.addTiming("6:00 AM - 10:00 PM");
        jasola_vihar.addTiming("6:00 AM - 10:00 PM");
        kalindi_kunj.addTiming("6:00 AM - 10:00 PM");
        okhla_bird_sanctuary.addTiming("6:15 AM - 10:30 PM");
        botanical_garden.addTiming("8:00 AM - 10:00 PM");


        millennium_city_centre.addNeighbor(iffco_chowk, 2);
        iffco_chowk.addNeighbor(mg_road, 2);
        mg_road.addNeighbor(sikanderpur, 2);
        sikanderpur.addNeighbor(guru_dronacharya, 3);
        guru_dronacharya.addNeighbor(arjan_garh, 5);
        arjan_garh.addNeighbor(ghitorni, 5);
        ghitorni.addNeighbor(sultanpur, 2);
        sultanpur.addNeighbor(chattarpur, 3);
        chattarpur.addNeighbor(qutab_minar, 4);
        qutab_minar.addNeighbor(saket, 4);
        saket.addNeighbor(malviya_nagar, 2);
        malviya_nagar.addNeighbor(hauz_khas, 4);
        hauz_khas.addNeighbor(green_park, 5);
        green_park.addNeighbor(aiims, 5);
        aiims.addNeighbor(ina, 2);
        ina.addNeighbor(jor_bagh, 3);
        jor_bagh.addNeighbor(lok_kalyan_marg, 2);
        lok_kalyan_marg.addNeighbor(udyog_bhawan, 2);
        udyog_bhawan.addNeighbor(central_secretariat, 2);
        central_secretariat.addNeighbor(patel_chowk, 3);
        patel_chowk.addNeighbor(rajiv_chowk, 5);
        rajiv_chowk.addNeighbor(new_delhi, 5);
        new_delhi.addNeighbor(chawri_bazar, 2);
        chawri_bazar.addNeighbor(chandni_chowk, 3);
        chandni_chowk.addNeighbor(kashmere_gate, 2);
        kashmere_gate.addNeighbor(civil_lines, 2);
        civil_lines.addNeighbor(vidhan_sabha, 2);
        vidhan_sabha.addNeighbor(vishwavidyalaya, 3);
        vishwavidyalaya.addNeighbor(gtb_nagar, 5);
        gtb_nagar.addNeighbor(model_town, 5);
        model_town.addNeighbor(adarsh_nagar, 2);
        adarsh_nagar.addNeighbor(jahangiripuri, 3);
        rajiv_chowk.addNeighbor(barakhamba_road, 5);
        barakhamba_road.addNeighbor(mandi_house, 2);
        mandi_house.addNeighbor(supreme_court, 3);
        supreme_court.addNeighbor(yamuna_bank, 2);
        yamuna_bank.addNeighbor(laxmi_nagar, 2);
        laxmi_nagar.addNeighbor(nirman_vihar, 2);
        nirman_vihar.addNeighbor(preet_vihar, 3);
        preet_vihar.addNeighbor(karkarduma, 5);
        karkarduma.addNeighbor(anand_vihar, 5);
        anand_vihar.addNeighbor(kaushambi, 2);
        kaushambi.addNeighbor(vaishali, 3);
        vaishali.addNeighbor(kaushambi, 5);
        kaushambi.addNeighbor(anand_vihar, 2);
        anand_vihar.addNeighbor(karkarduma, 3);
        karkarduma.addNeighbor(preet_vihar, 2);
        preet_vihar.addNeighbor(nirman_vihar, 2);
        nirman_vihar.addNeighbor(laxmi_nagar, 2);
        laxmi_nagar.addNeighbor(yamuna_bank, 3);
        yamuna_bank.addNeighbor(supreme_court, 5);
        supreme_court.addNeighbor(mandi_house, 5);
        mandi_house.addNeighbor(barakhamba_road, 2);
        barakhamba_road.addNeighbor(rajiv_chowk, 3);
        rajiv_chowk.addNeighbor(ra_marg, 5);
        ra_marg.addNeighbor(jhandewalan, 2);
        jhandewalan.addNeighbor(karol_bagh, 3);
        karol_bagh.addNeighbor(rajendra_palace, 2);
        rajendra_palace.addNeighbor(patel_nagar, 2);
        patel_nagar.addNeighbor(shadipur, 2);
        shadipur.addNeighbor(kirti_nagar, 3);
        kirti_nagar.addNeighbor(moti_nagar, 5);
        moti_nagar.addNeighbor(ramesh_nagar, 5);
        ramesh_nagar.addNeighbor(rajouri_garden, 2);
        rajouri_garden.addNeighbor(tagore_garden, 3);
        tagore_garden.addNeighbor(subhash_nagar, 3);
        subhash_nagar.addNeighbor(tilak_nagar, 5);
        tilak_nagar.addNeighbor(janakpuri_east, 2);
        janakpuri_east.addNeighbor(janakpuri_west, 3);
        janakpuri_west.addNeighbor(uttam_nagar_east, 2);
        uttam_nagar_east.addNeighbor(uttam_nagar_west, 2);
        uttam_nagar_west.addNeighbor(nawada, 2);
        nawada.addNeighbor(dwarka_mor, 3);
        dwarka_mor.addNeighbor(dwarka, 5);
        dwarka.addNeighbor(dwarka_sec14, 5);
        dwarka_sec14.addNeighbor(dwarka_sec13, 2);
        dwarka_sec13.addNeighbor(dwarka_sec12, 3);
        dwarka_sec12.addNeighbor(dwarka_sec10, 5);
        dwarka_sec10.addNeighbor(dwarka_sec9, 2);
        dwarka_sec9.addNeighbor(dwarka_sec8, 3);
        dwarka_sec8.addNeighbor(dwarka_sec21, 2);
        dwarka_sec21.addNeighbor(dwarka_sec8, 2);
        dwarka_sec8.addNeighbor(dwarka_sec9, 2);
        dwarka_sec9.addNeighbor(dwarka_sec10, 3);
        dwarka_sec10.addNeighbor(dwarka_sec11, 5);
        dwarka_sec11.addNeighbor(dwarka_sec12, 5);
        dwarka_sec12.addNeighbor(dwarka_sec13, 2);
        dwarka_sec13.addNeighbor(dwarka_sec14, 3);
        dwarka_sec14.addNeighbor(dwarka, 5);
        dwarka.addNeighbor(dwarka_mor, 2);
        dwarka_mor.addNeighbor(nawada, 3);
        nawada.addNeighbor(uttam_nagar_west, 2);
        uttam_nagar_west.addNeighbor(uttam_nagar_east, 2);
        uttam_nagar_east.addNeighbor(janakpuri_west, 2);
        janakpuri_west.addNeighbor(janakpuri_east, 3);
        janakpuri_east.addNeighbor(tilak_nagar, 5);
        tilak_nagar.addNeighbor(subhash_nagar, 5);
        subhash_nagar.addNeighbor(tagore_garden, 2);
        tagore_garden.addNeighbor(rajouri_garden, 3);
        rajouri_garden.addNeighbor(ramesh_nagar, 5);
        ramesh_nagar.addNeighbor(moti_nagar, 2);
        moti_nagar.addNeighbor(kirti_nagar, 3);
        kirti_nagar.addNeighbor(shadipur, 2);
        shadipur.addNeighbor(patel_nagar, 2);
        patel_nagar.addNeighbor(rajendra_palace, 2);
        rajendra_palace.addNeighbor(karol_bagh, 3);
        karol_bagh.addNeighbor(jhandewalan, 5);
        jhandewalan.addNeighbor(ra_marg, 5);
        ra_marg.addNeighbor(rajiv_chowk, 2);
        jahangiripuri.addNeighbor(adarsh_nagar, 3);
        adarsh_nagar.addNeighbor(model_town, 5);
        model_town.addNeighbor(gtb_nagar, 2);
        gtb_nagar.addNeighbor(vishwavidyalaya, 3);
        vishwavidyalaya.addNeighbor(vidhan_sabha, 2);
        vidhan_sabha.addNeighbor(civil_lines, 2);
        civil_lines.addNeighbor(kashmere_gate, 2);
        kashmere_gate.addNeighbor(chandni_chowk, 3);
        chandni_chowk.addNeighbor(chawri_bazar, 5);
        chawri_bazar.addNeighbor(new_delhi, 5);
        new_delhi.addNeighbor(rajiv_chowk, 2);
        rajiv_chowk.addNeighbor(patel_chowk, 3);
        patel_chowk.addNeighbor(central_secretariat, 3);
        central_secretariat.addNeighbor(udyog_bhawan, 5);
        udyog_bhawan.addNeighbor(lok_kalyan_marg, 2);
        lok_kalyan_marg.addNeighbor(jor_bagh, 3);
        jor_bagh.addNeighbor(ina, 2);
        ina.addNeighbor(aiims, 2);
        aiims.addNeighbor(green_park, 2);
        green_park.addNeighbor(hauz_khas, 3);
        hauz_khas.addNeighbor(malviya_nagar, 5);
        malviya_nagar.addNeighbor(saket, 5);
        saket.addNeighbor(qutab_minar, 2);
        qutab_minar.addNeighbor(chattarpur, 3);
        chattarpur.addNeighbor(sultanpur, 5);
        sultanpur.addNeighbor(ghitorni, 2);
        ghitorni.addNeighbor(arjan_garh, 3);
        arjan_garh.addNeighbor(guru_dronacharya, 2);
        guru_dronacharya.addNeighbor(sikanderpur, 2);
        sikanderpur.addNeighbor(mg_road, 2);
        mg_road.addNeighbor(iffco_chowk, 3);
        iffco_chowk.addNeighbor(millennium_city_centre, 5);
        sikanderpur.addNeighbor(phase1, 5);
        phase1.addNeighbor(sec42_43, 2);
        sec42_43.addNeighbor(sec53_54, 3);
        sec53_54.addNeighbor(sec55_56, 2);
        sec55_56.addNeighbor(sec53_54, 2);
        sec53_54.addNeighbor(sec42_43, 2);
        sec42_43.addNeighbor(phase1, 3);
        phase1.addNeighbor(sikanderpur, 5);
        sikanderpur.addNeighbor(phase2, 5);
        phase2.addNeighbor(phase3, 2);
        phase3.addNeighbor(moulsari_avenue, 3);
        moulsari_avenue.addNeighbor(cyber_city, 3);
        cyber_city.addNeighbor(belvedere_towers, 2);
        belvedere_towers.addNeighbor(phase2, 2);
        phase2.addNeighbor(belvedere_towers, 2);
        belvedere_towers.addNeighbor(cyber_city, 3);
        cyber_city.addNeighbor(moulsari_avenue, 5);
        moulsari_avenue.addNeighbor(phase3, 5);
        phase3.addNeighbor(phase2, 2);
        phase2.addNeighbor(sikanderpur,3);
        botanical_garden.addNeighbor(okhla_bird_sanctuary, 5);
        okhla_bird_sanctuary.addNeighbor(kalindi_kunj, 2);
        kalindi_kunj.addNeighbor(jasola_vihar, 3);
        jasola_vihar.addNeighbor(okhla_vihar, 2);
        okhla_vihar.addNeighbor(jamia_milia_islamia, 2);
        jamia_milia_islamia.addNeighbor(sukhdev_vihar, 2);
        sukhdev_vihar.addNeighbor(okhla, 3);
        okhla.addNeighbor(kalka_ji, 5);
        kalka_ji.addNeighbor(nehru_enclave, 5);
        nehru_enclave.addNeighbor(grater_kailash, 2);
        grater_kailash.addNeighbor(chirag_delhi, 3);
        chirag_delhi.addNeighbor(panchsheel, 3);
        panchsheel.addNeighbor(hauz_khas, 5);
        hauz_khas.addNeighbor(iit, 2);
        iit.addNeighbor(rk_puram, 3);
        rk_puram.addNeighbor(munirka, 2);
        munirka.addNeighbor(vasant_vihar, 2);
        vasant_vihar.addNeighbor(shankar_vihar, 2);
        shankar_vihar.addNeighbor(igi_t1, 3);
        igi_t1.addNeighbor(sadar_bazar, 5);
        sadar_bazar.addNeighbor(palam, 5);
        palam.addNeighbor(dashrathpuri, 2);
        dashrathpuri.addNeighbor(dabri_mor, 3);
        dabri_mor.addNeighbor(janakpuri_west, 5);
        janakpuri_west.addNeighbor(dabri_mor, 2);
        dabri_mor.addNeighbor(dashrathpuri, 3);
        dashrathpuri.addNeighbor(palam, 2);
        palam.addNeighbor(sadar_bazar, 2);
        sadar_bazar.addNeighbor(igi_t1, 2);
        igi_t1.addNeighbor(shankar_vihar, 3);
        shankar_vihar.addNeighbor(vasant_vihar, 5);
        vasant_vihar.addNeighbor(munirka, 5);
        munirka.addNeighbor(rk_puram, 2);
        rk_puram.addNeighbor(iit, 3);
        iit.addNeighbor(hauz_khas, 2);
        hauz_khas.addNeighbor(panchsheel, 2);
        panchsheel.addNeighbor(chirag_delhi, 2);
        chirag_delhi.addNeighbor(grater_kailash, 3);
        grater_kailash.addNeighbor(nehru_enclave, 5);
        nehru_enclave.addNeighbor(kalka_ji, 5);
        kalka_ji.addNeighbor(okhla, 2);
        okhla.addNeighbor(sukhdev_vihar, 3);
        sukhdev_vihar.addNeighbor(jamia_milia_islamia, 3);
        jamia_milia_islamia.addNeighbor(okhla_vihar, 2);
        okhla_vihar.addNeighbor(jasola_vihar, 2);
        jasola_vihar.addNeighbor(kalindi_kunj, 2);
        kalindi_kunj.addNeighbor(okhla_bird_sanctuary, 3);
        okhla_bird_sanctuary.addNeighbor(botanical_garden, 5);


        System.out.println("\t\t\t\t\t\t**WELCOME TO THE METRO APP** ");
        System.out.println("\t\t\t\t\t\t    ~List of All Actions~ \n");
        System.out.println("\t\t\t\t\t\t     Created by\n\t\t\t\t\t\t     Prabhdeep Singh (22CSU133)\n\t\t\t\t\t\t     Harsha (22CSU081)\n\t\t\t\t\t\t   & Mohd. Saarmeen Farooqui (22CSU119)");

        while (true) {
            System.out.println();
            System.out.println("Choose your option - ");
            System.out.println("1. List of all Stations");
            System.out.println("2. Display Metro time");
            System.out.println("3. Find Shortest Route");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("\nList of all Stations:\n");
                    for (Station station : allStations) {
                        System.out.println(station);
                    }
                        System.out.println();
                    break;
                    
                case 2:
                     System.out.println();
                     System.out.print("Enter the station: ");
                    String name = sc.next();
    
                    Station station = findStationByName(name, allStations);
    
                    if (station == null) {
                       System.out.println("Invalid station name. Please check the station name and try again.");
                     break;
                     }
    
                     System.out.println("Timings for " + station + ":");
    
                    for (String timing : station.timings) {
                            System.out.println(timing);
                    }
    
                         System.out.println();
                        break;
                    
                case 3:
                        System.out.println();
                    System.out.print("Enter the start station: ");
                    String startStationName = sc.next();
                    System.out.print("Enter the end station: ");
                    String endStationName = sc.next();
                    

                    startStation = findStationByName(startStationName, allStations);
                    endStation = findStationByName(endStationName, allStations);
                    
                    if (startStation == null || endStation == null) {
                        System.out.println("Invalid station names. Please check the station names and try again.");
                        break;
                    }
                    
                    List<Station> shortestPath = dijkstra(startStation, endStation);

                    if (shortestPath == null) {
                        System.out.println("No path found between " + startStation + " and " + endStation);
                        break;
                    }

                    int shortestTime = 0;
                    for (int i = 0; i < shortestPath.size() - 1; i++) {
                    Station currentStation = shortestPath.get(i);
                    Station nextStation = shortestPath.get(i + 1);
                    shortestTime += currentStation.neighbors.get(nextStation);
                }
                    for (Station Station : shortestPath) {
                    System.out.print(Station.name + " -> ");
                    }
                    System.out.println();
                    System.out.println("Shortest time from " + startStation.name + " to " + endStation.name + ": " + shortestTime + " minutes");
                   break;
                   
                case 4:
                        System.out.println();
                   System.out.println("---------------------Exiting Metro App.--------------------");
                   System.exit(0);
                       System.out.println();
                   break;
                   
                default:
                    System.out.println();
                   System.out.println("Invalid choice. Please enter a valid choice.");
                   
            }
        }
    }
}