﻿using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class CompStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public CompStmnt(params ITypeCheckStmnt[] stmnts)
            : base(stmnts)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            queue = new Queue<ITypeCheckStmnt>();

            foreach (ITypeCheckStmnt item in Statements)
            {
                //item.TypeCheck(queue, data);
                queue.Enqueue(item);
            }

            while (queue.Count > 0)
            {
                queue.Dequeue().TypeCheck(queue, data);
            }
        }
    }
}