public interface Loadable {

    /***
     *
     * @param load Adding object to Loadable
     * @param <A> Type of objects to load
     */
    <A> void load(A load);

    /***
     * Deload load
     */
    void deLoad();


}