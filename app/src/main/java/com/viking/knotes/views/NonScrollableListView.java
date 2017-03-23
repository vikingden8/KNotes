/*
 * Copyright (C) 2017 Viking Den <vikingden@live.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.viking.knotes.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;


public class NonScrollableListView extends ListView {

    public NonScrollableListView(Context context) {
        super(context);
    }


    public NonScrollableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public NonScrollableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void justifyListViewHeightBasedOnChildren() {

        ListAdapter adapter = getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = this;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = getLayoutParams();
        par.height = totalHeight + (getDividerHeight() * (adapter.getCount() - 1));
        setLayoutParams(par);
        requestLayout();
    }
}
