package deepdive.cnm.edu.trips;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


/**
 * Hotel {@link Fragment} subclass.
 */
public class Hotel extends Fragment {


  public Hotel() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_hotel, container, false);
//    puts in EXPAND view
    view.findViewById(R.id.calendar_check_in).setVisibility(View.VISIBLE);
    view.findViewById(R.id.calendar_check_out).setVisibility(View.VISIBLE);
    view.findViewById(R.id.hotel_address).setVisibility(View.GONE);
    view.findViewById(R.id.hotel_phone).setVisibility(View.GONE);
    view.findViewById(R.id.hotel_check_in).setVisibility(View.GONE);
    view.findViewById(R.id.hotel_check_out).setVisibility(View.GONE);
    view.findViewById(R.id.calendar_check_in_2).setVisibility(View.GONE);
    view.findViewById(R.id.calendar_check_out_2).setVisibility(View.GONE);
    view.findViewById(R.id.name_on_reservation).setVisibility(View.GONE);
    view.findViewById(R.id.hotel_confirmation).setVisibility(View.GONE);
    view.findViewById(R.id.hotel_rewards).setVisibility(View.GONE);
    view.findViewById(R.id.room_type).setVisibility(View.GONE);
    view.findViewById(R.id.hotel_cost).setVisibility(View.GONE);
//    expands card
    view.findViewById(R.id.hotel_card_1).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (view.findViewById(R.id.calendar_check_in).getVisibility() == View.VISIBLE) {
          view.findViewById(R.id.calendar_check_in).setVisibility(View.GONE);
          view.findViewById(R.id.calendar_check_out).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_address).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_phone).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_check_in).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_check_out).setVisibility(View.VISIBLE);
          view.findViewById(R.id.calendar_check_in_2).setVisibility(View.VISIBLE);
          view.findViewById(R.id.calendar_check_out_2).setVisibility(View.VISIBLE);
          view.findViewById(R.id.name_on_reservation).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_confirmation).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_rewards).setVisibility(View.VISIBLE);
          view.findViewById(R.id.room_type).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_cost).setVisibility(View.VISIBLE);
        } else {
          view.findViewById(R.id.calendar_check_in).setVisibility(View.VISIBLE);
          view.findViewById(R.id.calendar_check_out).setVisibility(View.VISIBLE);
          view.findViewById(R.id.hotel_address).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_phone).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_check_in).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_check_out).setVisibility(View.GONE);
          view.findViewById(R.id.calendar_check_in_2).setVisibility(View.GONE);
          view.findViewById(R.id.calendar_check_out_2).setVisibility(View.GONE);
          view.findViewById(R.id.name_on_reservation).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_confirmation).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_rewards).setVisibility(View.GONE);
          view.findViewById(R.id.room_type).setVisibility(View.GONE);
          view.findViewById(R.id.hotel_cost).setVisibility(View.GONE);
        }
      }
    });
    return view;
  }



}
