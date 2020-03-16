public class AreaStringOutputter {
    AreaAggregator aggregator;

    AreaStringOutputter(AreaAggregator aggregator) {
        this.aggregator = aggregator;
    }

    public double output() {
        return aggregator.sum();
    }
}
