package de.zalando.zmon.scheduler.ng.entities;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jmussler on 4/2/15.
 */
public class DeployCtlInstanceAdapter extends EntityAdapter {

    private final static Logger LOG = LoggerFactory.getLogger(DeployCtlInstanceAdapter.class);

    private MetricRegistry metrics;
    private Timer timer;

    public DeployCtlInstanceAdapter(MetricRegistry metrics) {
        super("DeployCtlAdapter");
        this.metrics = metrics;
        this.timer = metrics.timer("entity-adapter.deployctlinstances");
    }

    @Override
    public Collection<Entity> getCollection() {
        Timer.Context tC = timer.time();
        LOG.info("DeployCtlInstance Adapter used: {}ms", tC.stop() / 1000000);
        return new ArrayList<>();
    }
}