package org.nobel.topliftcrm.activities.tasks;

import org.nobel.highriseapi.entities.Task;
import org.nobel.highriseapi.resources.TaskResource;
import org.nobel.topliftcrm.R;
import org.nobel.topliftcrm.activities.base.EntityDetailActivity;
import org.nobel.topliftcrm.data.HighriseApiService;

import android.app.Activity;
import android.widget.TextView;

public class TaskDetailActivity extends EntityDetailActivity<Task> {

    public static final String TASK_LIST = "TASK_LIST";

    @Override
    protected Task getEntity(Integer id) {
        return HighriseApiService.getInstance(this).getResource(TaskResource.class).get(id);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.task_detail;
    }

    @Override
    protected Class<? extends Activity> getListActivity() {
        return TaskListActivity.class;
    }

    @Override
    protected void renderView(Task task) {

        TextView taskBodyText = (TextView) this.findViewById(R.id.taskBody);
        taskBodyText.setText(task.getBody());

        TextView taskFrameText = (TextView) this.findViewById(R.id.taskFrame);
        taskFrameText.setText(taskFrameText.getText() + task.getFrame());

    }

}
