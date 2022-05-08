// marker 변수, 위도 경도 정리해 놓은 클래스 Map.java에 import하여 사용될 정보모음
// marker_1,lat_1,lng_1 = park / 2 = photo / 3 = restaurant / 4 = toilet / 5 = cigar

//marker 1- 29 park / marker_p1- photh / marker_r1 - res / marker t-1 - toilet / marker_c1- cigar
package com.tutorial2.where_here.lat_lng;

import com.naver.maps.map.overlay.Marker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lating {
    public Marker marker1 = new Marker();
    public Marker marker2 = new Marker();
    public Marker marker3 = new Marker();
    public Marker marker4 = new Marker();
    public Marker marker5 = new Marker();
    public Marker marker6 = new Marker();
    public Marker marker7 = new Marker();
    public Marker marker8 = new Marker();
    public Marker marker9 = new Marker();
    public Marker marker10 = new Marker();
    public Marker marker11 = new Marker();
    public Marker marker12 = new Marker();
    public Marker marker13 = new Marker();
    public Marker marker14 = new Marker();
    public Marker marker15 = new Marker();
    public Marker marker16 = new Marker();
    public Marker marker17 = new Marker();
    public Marker marker18 = new Marker();
    public Marker marker19 = new Marker();
    public Marker marker20 = new Marker();
    public Marker marker21 = new Marker();
    public Marker marker22 = new Marker();
    public Marker marker23 = new Marker();
    public Marker marker24 = new Marker();
    public Marker marker25 = new Marker();
    public Marker marker26 = new Marker();
    public Marker marker27 = new Marker();
    public Marker marker28 = new Marker();
    public Marker marker29 = new Marker();

    public Marker marker_p1 = new Marker();

    public Marker marker_r1 = new Marker();
    public Marker marker_r2 = new Marker();
    public Marker marker_r3 = new Marker();
    public Marker marker_r4 = new Marker();
    public Marker marker_r5 = new Marker();
    public Marker marker_r6 = new Marker();
    public Marker marker_r7 = new Marker();
    public Marker marker_r8 = new Marker();
    public Marker marker_r9 = new Marker();
    public Marker marker_r10 = new Marker();
    public Marker marker_r11 = new Marker();
    public Marker marker_r12 = new Marker();
    public Marker marker_r13 = new Marker();
    public Marker marker_r14 = new Marker();
    public Marker marker_r15 = new Marker();
    public Marker marker_r16 = new Marker();

    public Marker marker_t1 = new Marker();
    public Marker marker_t2 = new Marker();
    public Marker marker_t3 = new Marker();
    public Marker marker_t4 = new Marker();
    public Marker marker_t5 = new Marker();
    public Marker marker_t6 = new Marker();
    public Marker marker_t7 = new Marker();

    public Marker marker_c1 = new Marker();
    public Marker marker_c2 = new Marker();
    public Marker marker_c3 = new Marker();
    public Marker marker_c4 = new Marker();
    public Marker marker_c5 = new Marker();




    public Marker[] marker_1 = {marker1,marker2,marker3,marker4,marker5,marker6,marker7,marker8,marker9,marker10,
                                marker11,marker12,marker13,marker14,marker15,marker16,marker17,marker18,marker19,marker20,
                                marker21,marker22,marker23,marker24,marker25,marker26,marker27, marker28, marker29};
    public Marker[] marker_p = {};
    public Marker[] marker_r = {marker_r1,marker_r2, marker_r3, marker_r4,marker_r5,marker_r6,marker_r7,marker_r8,
                                marker_r9,marker_r10,marker_r11,marker_r12,marker_r13,marker_r14,marker_r15,marker_r16};
    public Marker[] marker_t = {marker_t1,marker_t2,marker_t3,marker_t4,marker_t5,marker_t6,marker_t7};
    public Marker[] marker_c = {marker_c1,marker_c2,marker_c3,marker_c4,marker_c5};

    public double[] lat_1 = {35.8356756, 35.836504, 35.8369161, 35.8361529, 35.8364915,
            35.8366318, 35.83666, 35.836497, 35.8366296, 35.8360088,
            35.836136, 35.8363284, 35.8368068, 35.8369569, 35.8369221,
            35.8374461, 35.8372721, 35.8369009, 35.8368509, 35.83689,
            35.83674, 35.8355299, 35.8355973, 35.835332, 35.8358979,
            35.838555, 35.8380419, 35.8380609, 35.8373542};
    public double[] lng_1 = {129.2802138, 129.2803989, 129.280191, 129.2793005, 129.2820149,
            129.2819948,129.2816971,129.2815871,129.2814859, 129.2813303,
            129.2815797, 129.2817541, 129.2824957, 129.2820424, 129.281679,
            129.2812713, 129.2809481,129.2810158, 129.2812411, 129.2813779,
            129.2809018, 129.2813752, 129.2816689, 129.2822389,129.2819995,
            129.2820022, 129.2823884, 129.2830087, 129.282483};

    public double[] lat_p = {};
    public double[] lng_p = {};

    public double[] lat_r = {35.8363377, 35.8361876, 35.836366, 35.8360338, 35.8360479,
            35.8363812, 35.8367943, 35.8372118, 35.8372749, 35.8371444, 35.8381055, 35.8368617,
            35.8368041, 35.8368356, 35.8357506, 35.8355348};
    public double[] lng_r = {129.2833212, 129.2829993, 129.2827338, 129.2824448, 129.2826043,
            129.2823583, 129.2819908, 129.2820927, 129.281964, 129.2814704, 129.2820283, 129.2805853,
            129.2799939, 129.2800448, 129.2813618, 129.282253};

    public double[] lat_t = {35.8363214, 35.8347819, 35.8348601, 35.8362697, 35.8367612,
            35.8355522, 35.8382534};
    public double[] lng_t = {129.2812111, 129.2833139, 129.2825408, 129.2836277, 129.2806934,
            129.2823993, 129.282013};

    public double[] lat_c = {35.835606, 35.8350798, 35.8363714, 35.8374401, 35.8389296};
    public double[] lng_c = {129.2841996, 129.2817199, 129.2801374, 129.2809675, 129.2821115};


}