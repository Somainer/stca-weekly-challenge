/**
 * // Definition for a Node.
 * function Node(val,next,random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */
/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
    const cache = new WeakMap();
    const copy = (node) => {
      if(!node) return null;
      if (cache.has(node)) return cache.get(node);
      const copied = new Node(node.val, null, null);
      cache.set(node, copied);
      copied.next = copy(node.next);
      copied.random = copy(node.random);
      return copied;
    }
    return copy(head);
};