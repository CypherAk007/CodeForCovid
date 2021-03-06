// Generated by view binder compiler. Do not edit!
package com.example.code4covid_404notfound.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.code4covid_404notfound.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityInputDataBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText age;

  @NonNull
  public final Button button;

  @NonNull
  public final ConstraintLayout constraintlayout;

  @NonNull
  public final EditText contact;

  @NonNull
  public final EditText name;

  private ActivityInputDataBinding(@NonNull ConstraintLayout rootView, @NonNull EditText age,
      @NonNull Button button, @NonNull ConstraintLayout constraintlayout, @NonNull EditText contact,
      @NonNull EditText name) {
    this.rootView = rootView;
    this.age = age;
    this.button = button;
    this.constraintlayout = constraintlayout;
    this.contact = contact;
    this.name = name;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityInputDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityInputDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_input_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityInputDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.age;
      EditText age = rootView.findViewById(id);
      if (age == null) {
        break missingId;
      }

      id = R.id.button;
      Button button = rootView.findViewById(id);
      if (button == null) {
        break missingId;
      }

      ConstraintLayout constraintlayout = (ConstraintLayout) rootView;

      id = R.id.contact;
      EditText contact = rootView.findViewById(id);
      if (contact == null) {
        break missingId;
      }

      id = R.id.name;
      EditText name = rootView.findViewById(id);
      if (name == null) {
        break missingId;
      }

      return new ActivityInputDataBinding((ConstraintLayout) rootView, age, button,
          constraintlayout, contact, name);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
