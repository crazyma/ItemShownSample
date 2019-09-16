# ItemShownSample
To get the 'actual shown on screen' item in RecyclerView in many scenarios

## Background
The straightforward method is call `LayoutManager.findFirstVisibleItemPosition` & `LayoutManager.findLastVisibleItemPosition`. <br/>
However, There are many scenarios that the views are drawn on screen but not displayed on screen. For example:<br/>
 1. The recyclerview in the next/previous page in a ViewPager
 2. The recyclerview below a collapsable toolbar
<br/>
This sample project is test for all these complex scenarios. 
