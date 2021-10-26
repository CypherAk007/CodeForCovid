// Generated by view binder compiler. Do not edit!
package com.example.code4covid_404notfound.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.example.code4covid_404notfound.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFourmBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout FrameForum;

  @NonNull
  public final FloatingActionButton floatingActionButton;

  @NonNull
  public final RecyclerView rv;

  @NonNull
  public final SwipeRefreshLayout swipe;

  private FragmentFourmBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout FrameForum,
      @NonNull FloatingActionButton floatingActionButton, @NonNull RecyclerView rv,
      @NonNull SwipeRefreshLayout swipe) {
    this.rootView = rootView;
    this.FrameForum = FrameForum;
    this.floatingActionButton = floatingActionButton;
    this.rv = rv;
    this.swipe = swipe;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFourmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFourmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_fourm, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFourmBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout FrameForum = (FrameLayout) rootView;

      id = R.id.floatingActionButton;
      FloatingActionButton floatingActionButton = rootView.findViewById(id);
      if (floatingActionButton == null) {
        break missingId;
      }

      id = R.id.rv;
      RecyclerView rv = rootView.findViewById(id);
      if (rv == null) {
        break missingId;
      }

      id = R.id.swipe;
      SwipeRefreshLayout swipe = rootView.findViewById(id);
      if (swipe == null) {
        break missingId;
      }

      return new FragmentFourmBinding((FrameLayout) rootView, FrameForum, floatingActionButton, rv,
          swipe);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
