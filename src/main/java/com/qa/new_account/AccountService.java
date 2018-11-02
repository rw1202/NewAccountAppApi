package com.qa.new_account;


	import java.util.Collection;

	import javax.inject.Inject;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.Query;
	import javax.transaction.Transactional;

	@Transactional
	public class AccountService implements AccountRepo {
		@PersistenceContext(unitName="primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		
		
		public String getAllAccounts() {
			Query query = manager.createQuery("Select a FROM Account a");
			Collection<Account> AccList = (Collection<Account>) query.getResultList();
			return util.getJSONForObject(AccList);
		
		}
			
			@Transactional
		
		public String addAccount(String Account) {
//			JSONUtil util = new JSONUtil();
			Account acc1=util.getObjectForJSON (Account, Account.class);
			manager.persist(acc1);
			return "{\"message\":\"Account Added\"}";
		}
		
			@Transactional
			public String deleteAccount(Long Id) {
				Account accountInDB = findAccount(Id);
				if (accountInDB != null) {
					manager.remove(accountInDB);
				}
				
				return "{\"message\": \"movie sucessfully deleted\"}";
			
			}
			
			@Transactional
			public String updateAccount(Long Id, String Account) {
				Account acc1=util.getObjectForJSON (Account, Account.class);
				Account accountInDB=findAccount(Id);
				accountInDB.setFirstName(acc1.getFirstName());
				accountInDB.setLastName(acc1.getLastName());
				
			
				return "{\"message\":\"Account updated\"}";
				}
			
			
			
			public String getAccount(Long Id) {
				Account acc1 =  manager.find(Account.class, Id);
				return util.getJSONForObject(acc1);
			}

			private Account findAccount(Long Id) {
				return manager.find(Account.class, Id);
			}

			public void setManager(EntityManager manager) {
				this.manager = manager;
			}

			public void setUtil(JSONUtil util) {
				this.util = util;
			}



			

		}


