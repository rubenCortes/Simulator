package layout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import bennucybercafe.com.ve.simulator.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Principal.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Principal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Principal extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(View vista);
    }

    public Principal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Principal.
     */
    // TODO: Rename and change types and number of parameters
    public static Principal newInstance(String param1, String param2) {
        Principal fragment = new Principal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_principal, container, false);


        Button btnCasing = (Button) vista.findViewById(R.id.btn_casing);
        Button btnTubing = (Button) vista.findViewById(R.id.btn_tubing);
        Button btnPacker = (Button) vista.findViewById(R.id.btn_packer);
        Button btnFfUp = (Button) vista.findViewById(R.id.btn_ff_up);
        Button btnFfDown = (Button) vista.findViewById(R.id.btn_ff_down);

        btnCasing.setOnClickListener(this);
        btnTubing.setOnClickListener(this);
        btnPacker.setOnClickListener(this);
        btnFfUp.setOnClickListener(this);
        btnFfDown.setOnClickListener(this);

        return vista;
    }

    @Override
    public void onClick(View v) {
       // Toast.makeText(getActivity(), String.valueOf(v.getId()) , Toast.LENGTH_LONG).show();
        //onButtonPressed( v );
        if (mListener != null) {
            mListener.onFragmentInteraction( v );
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
/*    public void onButtonPressed(View v) {
        if (mListener != null) {
            mListener.onFragmentInteraction( v );
        }
    }*/

/*    @Override
    public void onAttach(Context contexto) {
        super.onAttach(contexto);
        if (contexto instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) contexto;
        } else {
            throw new RuntimeException(contexto.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
    }
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity);
        }
    }
    protected void onAttachToContext(Context contexto) {
        //do what you want / cast fragment listener

        if (contexto instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) contexto;
        } else {
            throw new RuntimeException(contexto.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
