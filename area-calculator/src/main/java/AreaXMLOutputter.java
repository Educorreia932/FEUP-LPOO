public class AreaXMLOutputter {
    AreaAggregator aggregator;

    AreaXMLOutputter(AreaAggregator aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "<area>" + aggregator.sum() + "</area>";
    }
}
