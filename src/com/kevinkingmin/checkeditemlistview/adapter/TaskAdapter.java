package com.kevinkingmin.checkeditemlistview.adapter;

import java.util.List;

import com.kevinkingmin.checkeditemlistview.R;
import com.kevinkingmin.checkeditemlistview.TaskItemClickEvent;
import com.kevinkingmin.checkeditemlistview.item.TaskItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<TaskItem> {
	/**
	 * ListView閫傞厤鍣�
	 * 
	 * @author Administrator
	 * 
	 */

	private int resourceId;

	private int selectedViewId;
	private int unselectedViewId;
	private int unselectedBackgroundId;
	private int selectedBackgroundId;

	private TaskItemClickEvent event;

	public TaskAdapter(Context context, int resource, int selectedViewId, int unselectedViewId,
			int unselectedBackgroundId, int selectedBackgroundId, List<TaskItem> tasks, TaskItemClickEvent event) {
		super(context, resource, tasks);
		this.resourceId = resource;
		this.unselectedBackgroundId = unselectedBackgroundId;
		this.selectedBackgroundId = selectedBackgroundId;
		this.unselectedViewId = unselectedViewId;
		this.selectedViewId = selectedViewId;
		this.event = event;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		System.out.println("convertView == null" + (convertView == null));
		ViewHolder viewHolder = new ViewHolder();
		TaskItem task = getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
			viewHolder.tvTubeNumber = (TextView) convertView.findViewById(R.id.tv_list_task_item1);
			viewHolder.tvSampleNumber = (TextView) convertView.findViewById(R.id.tv_list_task_item2);

			viewHolder.img1 = (ImageView) convertView.findViewById(R.id.tv_list_task_item3);
			viewHolder.img2 = (ImageView) convertView.findViewById(R.id.tv_list_task_item4);
			viewHolder.img3 = (ImageView) convertView.findViewById(R.id.tv_list_task_item5);
			viewHolder.img4 = (ImageView) convertView.findViewById(R.id.tv_list_task_item6);
			viewHolder.img5 = (ImageView) convertView.findViewById(R.id.tv_list_task_item7);
			viewHolder.img6 = (ImageView) convertView.findViewById(R.id.tv_list_task_item8);
			viewHolder.img7 = (ImageView) convertView.findViewById(R.id.tv_list_task_item9);
			viewHolder.img8 = (ImageView) convertView.findViewById(R.id.tv_list_task_item10);

			final ViewHolder viewHolder1 = viewHolder;
			OnClickListener onClickListener = new OnClickListener() {

				@Override
				public void onClick(View v) {

					TaskItem task = getItem(position);
					if (v.getId() == viewHolder1.img1.getId()) {
						task.setCheckedOne(!task.isCheckedOne());
					} else if (v.getId() == viewHolder1.img2.getId()) {
						task.setCheckedTwo(!task.isCheckedTwo());
					} else if (v.getId() == viewHolder1.img3.getId()) {
						task.setCheckedThree(!task.isCheckedThree());
					} else if (v.getId() == viewHolder1.img4.getId()) {
						task.setCheckedFour(!task.isCheckedFour());
					} else if (v.getId() == viewHolder1.img5.getId()) {
						task.setCheckedFive(!task.isCheckedFive());
					} else if (v.getId() == viewHolder1.img6.getId()) {
						task.setCheckedSix(!task.isCheckedSix());
					} else if (v.getId() == viewHolder1.img7.getId()) {
						task.setCheckedSeven(!task.isCheckedSeven());
					} else {
						task.setCheckedEight(!task.isCheckedEight());
					}

					event.onItemClicked(position);
				}
			};

			viewHolder.img1.setOnClickListener(onClickListener);
			viewHolder.img2.setOnClickListener(onClickListener);
			viewHolder.img3.setOnClickListener(onClickListener);
			viewHolder.img4.setOnClickListener(onClickListener);
			viewHolder.img5.setOnClickListener(onClickListener);
			viewHolder.img6.setOnClickListener(onClickListener);
			viewHolder.img7.setOnClickListener(onClickListener);
			viewHolder.img8.setOnClickListener(onClickListener);
			convertView.setTag(viewHolder);

			viewHolder.tvTubeNumber.setText(task.getTubeNumber());
			viewHolder.tvSampleNumber.setText(task.getSampleNumber());
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		convertView.setBackgroundResource(task.isSelectedItem() ? selectedBackgroundId : unselectedBackgroundId);
		viewHolder.tvTubeNumber.setText(task.getTubeNumber());
		viewHolder.tvSampleNumber.setText(task.getSampleNumber());

		viewHolder.img1.setImageResource(getViewId(task.isCheckedOne()));
		viewHolder.img2.setImageResource(getViewId(task.isCheckedTwo()));
		viewHolder.img3.setImageResource(getViewId(task.isCheckedThree()));
		viewHolder.img4.setImageResource(getViewId(task.isCheckedFour()));
		viewHolder.img5.setImageResource(getViewId(task.isCheckedFive()));
		viewHolder.img6.setImageResource(getViewId(task.isCheckedSix()));
		viewHolder.img7.setImageResource(getViewId(task.isCheckedSeven()));
		viewHolder.img8.setImageResource(getViewId(task.isCheckedEight()));
		return convertView;
	}

	public int getViewId(boolean isSelect) {
		return isSelect ? selectedViewId : unselectedViewId;
	}

	class ViewHolder {
		TextView tvTubeNumber;
		TextView tvSampleNumber;

		// 鐩存帴鏍规嵁浜嬩欢鏇存柊
		ImageView img1;
		ImageView img2;
		ImageView img3;
		ImageView img4;
		ImageView img5;
		ImageView img6;
		ImageView img7;
		ImageView img8;
	}

}
