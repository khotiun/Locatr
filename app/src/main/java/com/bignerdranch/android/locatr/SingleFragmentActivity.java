package com.bignerdranch.android.locatr;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hotun on 30.06.2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity{

    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId() {//метод, который возвращает идентификатор макета, заполняемого активностью.
       //аннотацией @LayoutRes, чтобы сообщить Android Studio, что любая реализация этого метода должна возвращать
        // действительный идентификатор ресурса макета.
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//если фрагмент находится в списке, нпример когда происходит поворот устройства

        if (fragment == null){//если фрагмент отсутствует
            fragment = createFragment();//создание фрагмента
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();//начало транзакции и добавление фрагмента в список FragmentManager
        }

    }
}
