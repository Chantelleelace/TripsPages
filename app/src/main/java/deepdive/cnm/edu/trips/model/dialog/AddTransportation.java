package deepdive.cnm.edu.trips.model.dialog;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import deepdive.cnm.edu.trips.MainActivity.AddCallBack;
import deepdive.cnm.edu.trips.R;
import deepdive.cnm.edu.trips.controller.DateTimeFragment;
import deepdive.cnm.edu.trips.controller.DateTimeFragment.Mode;
import deepdive.cnm.edu.trips.controller.DateTimeFragment.OnChangeListener;
import deepdive.cnm.edu.trips.model.db.TripsDatabase;
import deepdive.cnm.edu.trips.model.entity.Transportation;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass that lets the user add their own hotel information to
 * create new cards.
 */
public class AddTransportation extends DialogFragment {

  private TextInputEditText pickUpDate;
  private TextInputEditText returnDate;
  private Calendar calendar;
  private AddCallBack addCallBack;

  public AddTransportation() {
    // Required empty public constructor
  }

  private void pickUpDate(final TextInputEditText dateField) {
    DateTimeFragment picker = new DateTimeFragment();
    picker.setMode(Mode.DATE);
    picker.setCalendar(calendar);
    picker.show(getFragmentManager(), picker.getClass().getSimpleName());
    picker.setListener(new OnChangeListener() {
      /**
       * This get the date from my date picker and adds it to my textInput field.
       * @param calendar
       */
      @Override
      public void onChange(Calendar calendar) {
        java.text.DateFormat format = DateFormat.getDateFormat(getActivity());
        dateField.setText(format.format(calendar.getTime()));
      }

    });
  }

  /**
   * This inflates the dialog for users to add their own data.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.fragment_add_transportation, container, false);
    pickUpDate = view.findViewById(R.id.pick_up_date_input);
    pickUpDate.setOnClickListener(new OnClickListener() {
      /**
       * This pulls up a date picker when the user clicks on the date field.
       * @param v
       */
      @Override
      public void onClick(View v) {
        pickUpDate(pickUpDate);
      }
    });
    returnDate = view.findViewById(R.id.return_date_input);
    returnDate.setOnClickListener(new OnClickListener() {
      /**
       * This pulls up a date picker when the user clicks on the date field.
       * @param v
       */
      @Override
      public void onClick(View v) {
        pickUpDate(returnDate);
      }
    });

    // saves all input to database.
    view.findViewById(R.id.submit_transportation).setOnClickListener(
        new View.OnClickListener() {
          /**
           * When the user clicks submit, the data that they entered will be stored in the DB
           * and then populated to create a new card.
           * @param v
           */
          public void onClick(View v) {
            Transportation transportation = new Transportation();
            if ( (((TextInputEditText)
                view.findViewById(R.id.rental_company_input)).getText() != null)) {
              transportation.setRentalCompanyName(((TextInputEditText)
                  view.findViewById(R.id.rental_company_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.rental_address_input)).getText() != null)) {
              transportation.setRentalCompanyAddress(((TextInputEditText)
                  view.findViewById(R.id.rental_address_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.rental_phone_number_input)).getText() != null)) {
              transportation.setRentalCompanyPhone(((TextInputEditText)
                  view.findViewById(R.id.rental_phone_number_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.return_date_input)).getText() != null)) {
              transportation.setRentalReturn(((TextInputEditText)
                  view.findViewById(R.id.return_date_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.pick_up_date_input)).getText() != null)) {
              transportation.setRentalPickUp(((TextInputEditText)
                  view.findViewById(R.id.pick_up_date_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.rental_car_type_input)).getText() != null)) {
              transportation.setCarType(((TextInputEditText)
                  view.findViewById(R.id.rental_car_type_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.rental_cost_input)).getText() != null)) {
              transportation.setRentalCost(((TextInputEditText)
                  view.findViewById(R.id.rental_cost_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.rental_name_on_reservation_input)).getText() != null)) {
              transportation.setRentalCost(((TextInputEditText)
                  view.findViewById(R.id.rental_name_on_reservation_input)).getText().toString());
            }
            if ((((TextInputEditText)
                view.findViewById(R.id.rental_confirmation_input)).getText() != null)) {
              transportation.setRentalCost(((TextInputEditText)
                  view.findViewById(R.id.rental_confirmation_input)).getText().toString());
            }
            dismiss();
            new TransportationTask().execute(transportation);
          }
        });

    return view;
  }

  /**
   * This add (Transportation) call back add a new card to my Transportation fragment from my
   * add transportation fragment.
   * @param addCallBack
   */
  public void setAddCallBack(AddCallBack addCallBack) {
    this.addCallBack = addCallBack;
  }

  private class TransportationTask extends AsyncTask<Transportation, Void, Void> {

    @Override
    protected Void doInBackground(Transportation... transportation) {
      TripsDatabase tripsDatabase = TripsDatabase.getInstance(getActivity());
      tripsDatabase.getTransportationDao().insert(transportation[0]);
      return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      addCallBack.update();
    }
  }

}

