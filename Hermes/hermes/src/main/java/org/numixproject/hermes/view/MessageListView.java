/*
Yaaic - Yet Another Android IRC Client

Copyright 2009-2013 Sebastian Kaspari

This file is part of Yaaic.

Yaaic is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Yaaic is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Yaaic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.numixproject.hermes.view;

import org.numixproject.hermes.R;
import org.numixproject.hermes.adapter.MessageListAdapter;
import org.numixproject.hermes.listener.MessageClickListener;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;

/**
 * A customized ListView for Messages
 *
 * @author Sebastian Kaspari <sebastian@yaaic.org>
 */
public class MessageListView extends ListView
{
    /**
     * Create a new MessageListView
     *
     * @param context
     */
    public MessageListView(Context context)
    {
        super(context);

        setOnItemClickListener(MessageClickListener.getInstance());

        setDivider(null);

        setCacheColorHint(0x000000);
        setVerticalFadingEdgeEnabled(false);

        // Message Background.
        setBackgroundColor(Color.parseColor("#f5f5f5"));
        setScrollBarStyle(SCROLLBARS_OUTSIDE_INSET);

        // Scale padding by screen density
        float density = context.getResources().getDisplayMetrics().density;
        int padding = (int) (5 * density);
        setPadding(padding, padding, padding, padding);
        setDivider(new ColorDrawable(0x00FFFFFFF));
        setDividerHeight(20);
        setTranscriptMode(TRANSCRIPT_MODE_NORMAL);
    }

    /**
     * Get the adapter of this MessageListView
     * (Helper to avoid casting)
     *
     * @return The MessageListAdapter
     */
    @Override
    public MessageListAdapter getAdapter()
    {
        return (MessageListAdapter) super.getAdapter();
    }
}
