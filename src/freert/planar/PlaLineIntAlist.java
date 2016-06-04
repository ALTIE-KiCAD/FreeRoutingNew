package freert.planar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import board.varie.BrdChangedArea;

/**
 * Needed simply because erasure makes impossible to differentiate a constructor with ArrayList <xxx> and ArrayList <yyy>
 * @author damiano
 */
public final class PlaLineIntAlist implements Iterable<PlaLineInt>
   {
   private final ArrayList<PlaLineInt>a_list;
   
   public PlaLineIntAlist(int size)
      {
      a_list = new ArrayList<PlaLineInt>(size);
      }
   
   public void addAll(Collection<PlaLineInt> p_list )
      {
      a_list.addAll(p_list);
      }
   
   public PlaLineIntAlist(PlaLineInt [] point_arr )
      {
      a_list = new ArrayList<PlaLineInt>(point_arr.length);
      
      for (int index=0; index<point_arr.length; index++)
         a_list.add(point_arr[index]);
      }
   
   public PlaLineInt add(PlaLineInt avalue)
      {
      if ( avalue == null ) return null;
      
      a_list.add(avalue);
      
      return avalue;
      }
   
   public PlaLineInt add(int index, PlaLineInt avalue)
      {
      if ( avalue == null ) return null;
      
      a_list.add(index, avalue);
      
      return avalue;
      }
   

   public void add_null (int index)
      {
      a_list.add(index, null);
      }

   public PlaLineInt set(int index, PlaLineInt avalue)
      {
      if ( avalue == null ) return null;
      
      a_list.set(index, avalue);
      
      return avalue;
      }

   
   
   public PlaLineInt get(int index)
      {
      return a_list.get(index);
      }
   
   public int size ()
      {
      return a_list.size();
      }
   
   public int size (int offset)
      {
      return size()+offset;
      }

   public PlaLineInt[] to_array()
      {
      return a_list.toArray(new PlaLineInt[size()]);
      }
   
   @Override
   public Iterator<PlaLineInt> iterator()
      {
      return a_list.iterator();
      }
   
   /**
    * Append to dest the remaining lines starting from pos
    * If src_pos is zero and dest is empty this actually copy the list
    * @param dest
    * @param src_pos
    */
   public void append_to(PlaLineIntAlist dest, int src_pos )
      {
      int poly_len = size();
      
      for (int index=src_pos; index<poly_len; index++)
         dest.add(get(index));
      }
   
   /**
    * Add to the p_area the corner that results from crossing line p_index with p_index+1
    * @param p_area
    * @param p_index
    * @param p_layer
    */
   public void changed_area_join_corner (BrdChangedArea p_area, int p_index, int p_layer )
      {
      PlaPointFloat corner = get(p_index).intersection_approx(get(p_index + 1));
      
      if ( corner.is_NaN() ) return;
      
      p_area.join(corner, p_layer);
      }

   }
