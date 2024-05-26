import { auth } from "@/auth";
import { SignInBtn } from "@/components/SignInBtn";
import { SignOutBtn } from "@/components/SignOutBtn";
import { getToken } from "next-auth/jwt";
import { unstable_noStore } from "next/cache";

export default async function AdminPage() {
  unstable_noStore();
  const session = await auth();

  if (!session) {
    return (
      <>
        <p>Access Denied</p>
        <SignInBtn />
      </>
    );
  }
  console.log({ mySession: session });
  const data = await fetch("http://localhost:8081/api/admin", {
    headers: {
      Authorization: `Bearer ${session.accessToken}`,
    },
  });
  //   const json = await data.json();
  console.log({ data });
  return (
    <div>
      <h1>Admin Page</h1>
      <p>This is an admin page</p>
      <SignOutBtn />
    </div>
  );
}
