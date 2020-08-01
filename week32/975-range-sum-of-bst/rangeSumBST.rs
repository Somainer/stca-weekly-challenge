// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn range_sum_bst(root: Option<Rc<RefCell<TreeNode>>>, l: i32, r: i32) -> i32 {
        fn range_sum(root: &Option<Rc<RefCell<TreeNode>>>, l: i32, r: i32) -> i32 {
            match &root {
                None => 0,
                Some(node) if node.borrow().val < l =>
                    range_sum(&node.borrow().right, l, r),
                Some(node) if node.borrow().val > r =>
                    range_sum(&node.borrow().left, l, r),
                Some(node) => {
                    let cell = node.borrow();
                    cell.val + range_sum(&cell.left, l, r) + range_sum(&cell.right, l, r)
                },
            }
        }
        range_sum(&root, l, r)
    }
}
