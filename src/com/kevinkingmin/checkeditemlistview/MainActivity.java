package com.kevinkingmin.checkeditemlistview;

import java.util.ArrayList;
import java.util.List;

import com.kevinkingmin.checkeditemlistview.adapter.TaskAdapter;
import com.kevinkingmin.checkeditemlistview.item.TaskItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	// Kevin
	private List<TaskItem> tasks = new ArrayList<>();
	private TaskAdapter taskAdapter;
	private int selectPosition = -1;
	private ListView lvTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvTask = (ListView) findViewById(R.id.lv_task);
		setDataAdapter();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setDataAdapter() {

		tasks.clear();
		for (int i = 0; i < 10; i++) {
			tasks.add(new TaskItem());
		}

		taskAdapter = new TaskAdapter(this, R.layout.home_list_item, R.drawable.home_cb_content_checked,
				R.drawable.home_cb_content_unchecked, R.color.home_item_unselected_color,
				R.color.home_item_selected_color, tasks, new TaskItemClickEvent() {

					@Override
					public void onItemClicked(int position) {
						selectPosition = position;
						for (int i = 0; i < tasks.size(); i++) {
							if (i == position) {
								tasks.get(i).setSelectedItem(true);
							} else {
								tasks.get(i).setSelectedItem(false);
							}
						}
						taskAdapter.notifyDataSetChanged();
					}
				});
		lvTask.setAdapter(taskAdapter);
	}
}
